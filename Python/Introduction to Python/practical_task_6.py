# Task 1
vowels = 'аеоёуюиыяэ'
text = input("Введите текст: ").lower()
text_vowels = [char for char in text if char in vowels]
print(f"Список гласных букв: {text_vowels}")
print(f'Длина списка: {len(text_vowels)}')


# Task 2
# from random import uniform
# first_team = []
# second_team = []
# winners = []
# for i in range(20):
#     first_team.append(round(uniform(5, 10), 2))
#     second_team.append(round(uniform(5, 10), 2))
# for i in range(len(first_team)):
#     if first_team[i] > second_team[i]:
#         winners.append(first_team[i])
#     elif second_team[i] > first_team[i]:
#         winners.append(second_team[i])
# print(f'Первая команда: {first_team}')
# print(f'Вторая команда: {second_team}')
# print(f'Победители тура: {winners}')

# Task 3
# two_dimencional_list = [[i, i+4, i+8] for i in range(1, 5)]
# print(two_dimencional_list)

# Task 4
# nice_list = [[[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[10, 11, 12], [13, 14, 15], [16, 17, 18]]]
# open_list = [number for item in nice_list for digits in item for number in digits]
# print(open_list)

# Task 5
# alfabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
# alfabet_dict = {}
# for letter in alfabet:
#     alfabet_dict[letter] = alfabet.index(letter)
# message = input("Введите сообщение: ")
# step = int(input("Введите сдвиг: "))
# encrypted_message = ''
# for letter in message:
#     encrypted_letter = None
#     if letter in alfabet and alfabet_dict[letter] + step > len(alfabet) - 1:
#         encrypted_letter = alfabet[len(alfabet) - (alfabet_dict[letter] + step)]
#     elif letter in alfabet:
#         encrypted_letter = alfabet[alfabet_dict[letter] + 3]
#     else:
#         encrypted_letter = letter
#     encrypted_message += encrypted_letter
# print(encrypted_message)
