# Task 1
# sum = 0
# with open('txt/numbers.txt') as numbers_file:
#     for line in numbers_file:
#         sum += int(line.strip())
# with open('txt/answers.txt','w') as answers_file:
#     answers_file.write(f'{sum}')

# Task 2
# with open('txt/zen.txt') as zen_file:
#     zen_lines = zen_file.readlines()
# print(*zen_lines[::-1])

# Task 3
# with open('txt/first_tour.txt') as first_tour_file:
#     K = int(first_tour_file.readline().strip()) # балл выще которого нужно набрать
#     # список участников состоит из списков [Имя, Фамилия, Балл]
#     participiants = [line.strip().split() for line in first_tour_file] #список участников
#     # такой же список но с участниками свыше балла K (2 по индексу элемент в списках)
#     second_tour_people = [human for human in participiants if int(human[2]) > K]
#     K = len(second_tour_people) # новое количество участников
# # Пузырьковая сортировка по баллам
# for i in range(len(second_tour_people) - 1):
#     for j in range(i + 1, len(second_tour_people)):
#         if int(second_tour_people[i][2]) < int(second_tour_people[j][2]):
#             second_tour_people[i],second_tour_people[j] = second_tour_people[j],second_tour_people[i]
# with open("txt/second_tour.txt",'w') as second_tour_file:
#     second_tour_file.write(f'{K}\n')
#     for i in range(len(second_tour_people)):
#         person = second_tour_people[i] 
#         # В файл записываются строки формата - Первая_буква_имени. Фамилия Балл
#         second_tour_file.write(f'{person[0][0][0]}. {person[1]} {person[2]}\n')            

# Task 4
# from collections import Counter
# with open('txt/text.txt') as text_file:
#     text = ""
#     for line in text_file:
#         if not line[-1].isalpha():
#             text += line[:-1].strip().lower().replace(" ","")
#         else:
#             text += line.strip().lower().replace(" ", "")
# analyse = list({key: round(value / len(text),3) for key,value in Counter(text).items()}.items())
# analyse[0],analyse[1] = analyse[1],analyse[0]
# # Пузырьковая сортировка по доле и алфавитному порядку
# for i in range(len(analyse) - 1):
#     for j in range(i + 1, len(analyse)):
#         if analyse[i][-1] < analyse[j][-1]:
#             analyse[i],analyse[j] = analyse[j],analyse[i]
#         elif analyse[i][-1] == analyse[j][-1] and ord(analyse[i][0]) > ord(analyse[j][0]):
#             analyse[i],analyse[j] = analyse[j],analyse[i]
# analyse = dict(analyse)
# with open('txt/analyse.txt','w') as analyse_file:
#     for key,value in analyse.items():
#         analyse_file.write(f'{key} {value}\n')

# Test 5
# import zipfile
# from collections import Counter
# from functools import reduce


# letters_count = 0
# alfabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
# non_alpha_keys = []
# alfabet_dict = {}

# for key,value in dict(enumerate(alfabet)).items():
#   alfabet_dict[value] = key
# with zipfile.ZipFile("voina_i_mir.txt.zip") as voina_i_mir_zip:
#   for file in voina_i_mir_zip.namelist():
#     if file[-4:] == '.txt':
#       filename = file
#   voina_i_mir_dict = Counter(voina_i_mir_zip.open(filename).read().decode()) 
# for key,value in voina_i_mir_dict.items():
#   if not key.isalpha():
#     non_alpha_keys.append(key)
# for key in non_alpha_keys:
#   del voina_i_mir_dict[key]
# for count in voina_i_mir_dict.values():
#   letters_count += count

# analyse = list({key: value / letters_count for key,value in voina_i_mir_dict.items()}.items())


# for i in range(len(analyse) - 1):
#     for j in range(i + 1, len(analyse)):
#         if analyse[i][-1] < analyse[j][-1]:
#             analyse[i],analyse[j] = analyse[j],analyse[i]
#         elif analyse[i][0] in alfabet and analyse[j][0] in alfabet:   
#           if alfabet_dict[analyse[i][0]] > alfabet_dict[analyse[j][0]]:
#             analyse[i],analyse[j] = analyse[j],analyse[i]
# with open("txt/voina_i_mir.txt",'w') as voina_i_mir:  
#   for key,value in dict(analyse).items():
#     voina_i_mir.write(f'{key} - {value}\n')