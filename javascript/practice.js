const saveNotes = (notes) =>
  localStorage.setItem('notes', JSON.stringify(notes))

const getSavedNotes = () => {
  const notesJSON = localStorage.getItem('notes')
  try {
    return notesJSON ? JSON.parse(notesJSON) : []
  } catch (e) {
    return []
  }
}

let notes = getSavedNotes()

const renderNotes = (notes, filters) => {
    const notesEl =   document.querySelector('#notes')
  
    notes = sortNotes(notes, filters.sortBy)
    const filteredNotes = notes.filter((note) =>
      note.title.toLowerCase().includes(filters.searchText.toLowerCase())
    )
  
    notesEl.innerHTML = ''
  
    if (filteredNotes.length > 0) { //if there is more than one note
      filteredNotes.forEach((note) => {
        const noteEl = generateNoteDOM(note)
        notesEl.appendChild(noteEl)
      })
    } else { //if there is no notes
      const emptyMessage = document.createElement('p')
      emptyMessage.textContent = "No result"
      emptyMessage.classList.add('empty-message') //adding a class in javascript
      notesEl.appendChild(emptyMessage)
    }
  }
  
  window.addEventListener('storage', e => {
      if (e.key === 'notes') {
          notes = JSON.parse(e.newValue)
          renderNotes(notes, filters)
      }
  })

  let notes = getSavedNotes()
renderNotes(notes, filters)

document.querySelector('#create-note').addEventListener('click', () => {
    const id = uuidv4()
    const timestamp = moment().valueOf()

    notes.push({
        id: id,
        title: '',
        body: '',
        createdAt: timestamp,
        updatedAt: timestamp
    })
    saveNotes(notes)
    location.assign(`edit.html#${id}`)
})

let notes = getSavedNotes()
renderNotes(notes, filters)

const sortNotes = (notes, sortBy) => {
  if (sortBy === 'byEdited') {
    return notes.sort((a, b) => {
    //b-a가 음수면 a가 위로 올라감. a가 최근일수록 상위에 두고 싶으므로 a가 크면 위로두기
      if (a.updatedAt > b.updatedAt) {
        return -1
      } else if (a.updatedAt < b.updatedAt) {
        return 1
      } else {
        return 0
      }
    })
  } else if (sortBy === 'byCreated') {
    return notes.sort((a, b) => {
      if (a.createdAt > b.createdAt) {
        return -1
      } else if (a.createdAt < b.createdAt) {
        return 1
      } else {
        return 0
      }
    })
  } else if (sortBy === 'alphabetical') {
    return notes.sort((a, b) => {
      if (a.title.toLowerCase() < b.title.toLowerCase()) {
        return -1
      } else if (a.title.toLowerCase() > b.title.toLowerCase()) {
        return 1
      } else {
        return 0
      }
    })
  } else {
    return notes
  }
}

let notes = getSavedNotes()
renderNotes(notes, filters)

const filters = {
    searchText: '',
    sortBy: 'byEdited'
}
document.querySelector('#search-text').addEventListener('input', e => {
    filters.searchText = e.target.value
    renderNotes(notes, filters)
})

const generateLastEdited = (timestamp) => `Last edited ${moment(timestamp).fromNow()}`

const dateElement = document.querySelector("#last-edited");
dateElement.textContent = generateLastEdited(note.updatedAt);

const noteId = location.hash.substring(1);
let note = notes.find(note => note.id === noteId);

const removeNote = (id) => {
  const noteIndex = notes.findIndex((note) => note.id === id)

  if (noteIndex > -1) {
    notes.splice(noteIndex, 1)
  }
}

const removeElement = document.querySelector("#remove-note");

removeElement.addEventListener("click", () => {
  removeNote(note.id);
  saveNotes(notes);
  location.assign("index.html");
});