import random

number_input = Element("number_input")
def play_game(*args):
    user_guess = number_input.value
    machine_guess = random.randint(1, 50)
    if int(user_guess) == machine_guess:
        # user wins
        result.element.innerText = "You win!"
    else:
        # user loses
        reslut.element.innerText = "You lost! The machine chose {machine_guess}!"
    number_input.clear()