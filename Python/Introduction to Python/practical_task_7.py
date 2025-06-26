# Task 1
# from functools import reduce
# floats = [12.3554, 4.02, 5.777, 2.12, 3.13, 4.44, 11.0001]
# names = ["Vanes", "Alen", "Jana", "William", "Richards", "Joy"]
# numbers = [22, 33, 10, 6894, 11, 2, 1]

# new_floats = list(map(lambda float: round((float**3),3),floats))
# new_names = list(filter(lambda string: len(string) >= 5,names))
# new_numbers = reduce(lambda a, b: a * b,numbers)

# print(new_floats)
# print(new_names)
# print(new_numbers)

# Task 2
# letters = ['a', 'b', 'c', 'd', 'e']
# numbers = [1, 2, 3, 4, 5, 6, 7, 8]
# letters_and_numbers = list(map(lambda a, b: (a, b),letters, numbers))
# print(letters_and_numbers)

# Task 3


# def can_be_poly(string):
#     return string == string[::-1]


# print(can_be_poly('abcba'))

# Task 4
from functools import reduce
from collections import Counter
message = "Today is a beautiful day! The sun is shining and the birds are singing.".lower()
def counting_unique_charakters(string):
    return reduce(lambda x,y: x + y, filter(lambda count: count == 1,
                                            Counter(string).values()))
print(counting_unique_charakters(message))