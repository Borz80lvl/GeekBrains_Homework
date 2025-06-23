# Task 1
array_1 = [1, 5, 10, 20, 40, 80, 100]
array_2 = [6, 7, 20, 80, 100]
array_3 = [3, 4, 15, 20, 30, 70, 80, 120]
intersection_array = []
array_1_diff_arrays = []
for number in array_3:
    if number in array_2 and number in array_3:
        intersection_array.append(number)
for number in array_1:
    if not number in array_2 and not number in array_2:
        array_1_diff_arrays.append(number)
print("Задача 1:")
print(f"Решение без множеств: {intersection_array}")
print(f"Решение с множествами: {set(array_1).intersection(set(array_2)).intersection(set(array_3))}")
print("Задача 2:")
print(f"Решение без множеств: {array_1_diff_arrays}")
print(f"Решение с множествами: {set(array_1) - set(array_2).union(set(array_3))}")

# Task 2
# list_palindrom = list(input("Введите строку: ")) # Список букв в строке
# odd_values_count = 0
# for symbol in list_palindrom:
#     if list_palindrom.count(symbol) % 2 != 0:
#         odd_values_count += 1
# if odd_values_count > 1:
#     print("Нельзя сделать палиндромом")
# else:
#     print("Можно сделать палиндромом")

# Task 3
# synonims_count = int(input("Введите количество пар слов: "))
# synonims_dict = {}
# for number in range(1,synonims_count + 1):
#     synonims = input(f"{number}-я пара: ").replace("—"," ").split()
#     synonims_dict[synonims[0]] = synonims[1]
# while True:
#     synonim = input("Введите слово: ").capitalize()
#     if synonim in list(synonims_dict.keys()):
#         print(f"Синоним: {synonims_dict[synonim]}")
#         break
#     else:
#         print("Такого слова в словаре нет.")

# Task 4
# text = input("Введите текст: ")
# original_dict = {}
# inverted_dict = {}
# for char in text:
#     if not char in list(original_dict.keys()):
#         original_dict[char] = text.count(char)
# for key,value in original_dict.items():
#     if value in list(inverted_dict.keys()):
#         inverted_dict[value].append(key)
#     else:
#         inverted_dict[value] = [key]
# print(f"Оригинальный словарь {original_dict}")
# print(f"Инвентированный словарь {inverted_dict}") 
