# 4.7.8. Function Annotations
def f(ham:str, eggs: str  = 'eggs') -> str:
    print("Annoataions:", f.__annotations__)
    print("Arguments:", ham, eggs)
    return ham + ' and ' + eggs

f('spam')

# 4.7.7. Documetnation Strings
def my_function():
    """
    Do nothing, but document it.

    No, really, it doesn't do anything.
    """
    pass

print(my_function.__doc__)
