# Task 1
numbers_array = [] # Числа
pozitif_numbers_count = 0 # Количество положительных чисел
negatif_numbers_count = 0 # Количество отрицательных чисел
while True:
    number = int(input("Введите число: "))
    if number == 0:
        break
    numbers_array.append(number)
for number in numbers_array:
    if number > 0:
        pozitif_numbers_count += 1
    else: negatif_numbers_count += 1
print(f"Кол-во положительных чисел: {pozitif_numbers_count}")
print(f"Кол-во отрицательных чисел: {negatif_numbers_count}")

# Task 2
# task_count = 1 # Количество выполненных задач
# task_count_sum = 0 # Сумма выполненных задач
# piked_up_the_phone = False # Нужно ли пойти в магазин
# print("Начался восьмичасовой рабочий день.")
# for hour in range(1,9):
#     print(f"{hour}-й час")
#     print(f"Сколько задач решит Максим? {task_count}")
#     task_count_sum += task_count
#     if task_count == 5:
#         task_count = 1
#     else: task_count += 1
#     if int(input("Звонит жена.Взять трубку? (1 — да,0  — нет): ")) == 1:
#         piked_up_the_phone = True
# print(f"Рабочий день закончился. Всего выполнено задач: {task_count_sum}")
# if piked_up_the_phone: print("Нужно зайти в магазин.")

# Task 3
# number = 7
# try_count = 0
# while True:
#     users_number = int(input("Введите число: "))
#     if users_number == number:
#         print(f"Вы угадали! Число попыток: {try_count}")
#         break
#     elif users_number > number:
#         print(f"Число больше, чем нужно.Попробуйте еше раз!")
#         try_count += 1
#     else:
#         print(f"Число меньше, чем нужно.Попробуйте еше раз!")
#         try_count += 1

# Task 4
# year_salary_sum = 0 # Сумма зарплат за год
# for month in range(1,13):
#     year_salary_sum += int(input(f"Введите зарплату сотрудника за {month}-й месяц: "))
# print(f"Средняя зарплата за год: {year_salary_sum / 12}")

# Task 5
# N = int(input("Введите число карточек: "))
# card_numbers = set(range(1,N + 1)) # Номера карточек от 1 до N
# remaining_cards = [] # Номера оставшихся карточек
# print("Введите номера оставшихся карточек")
# for number in range(0,len(card_numbers) - 1):
#     remaining_cards.append(int(input("Номер карточки: ")))
# remaining_cards = set(remaining_cards)
# print(f"Номер потерянной карточки: {str(card_numbers - remaining_cards)[1]}")

# Task 6
# boys_count = int(input("Введите количество мальчиков: "))
# girls_count = int(input("Введите количество девочек: "))
# boys = 0 + boys_count # boys count
# girls = 0 + girls_count # girls count
# seating_plan = []
# if boys_count >= girls_count*2 or girls_count >= boys_count*2:
#     print("Нет решения")
# elif boys_count == girls_count:
#     print("b"*boys_count,"g"*girls_count)
# elif boys_count > girls_count:
#     while boys != -1:
#         seating_plan.append('b')
#         boys -= 1
#         if girls != 0:
#             seating_plan.append('g')
#             girls -= 1 
#     seating_plan = str(seating_plan).replace("'","").replace(",","").replace(" ","")[1:-2] 
#     if "bb" in seating_plan:
#         print("Нет решения")
#     else:  print("b"*boys_count,"g"*girls_count)
# else:
#     while girls != -1:
#         seating_plan.append('g')
#         girls -= 1
#         if boys != 0:
#             seating_plan.append('b')
#             boys -= 1 
#     seating_plan = str(seating_plan).replace("'","").replace(",","").replace(" ","")[1:-2] 
#     if "gg" in seating_plan:
#         print("Нет решения")
#     else:  print("b"*boys_count,"g"*girls_count)