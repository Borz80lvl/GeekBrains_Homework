# Task 1
video_card_count = int(input("Введите количество видеокарт: "))
video_cards = []
newest_video_card = 0
for number in range(1,video_card_count  +  1):
    video_cards.append(int(input(f"Видеокарта {number}: ")))
for video_card in video_cards:
    if video_card > newest_video_card:
        newest_video_card = video_card
print(f"Старый список видеокарт: {video_cards}")
while newest_video_card in video_cards:
    video_cards.remove(newest_video_card)
print(f"Новый список видеокарт: {video_cards}")

# Task 2
# favoriate_films_count = int(input("Сколько фильмов хотите добавить? "))
# favoriate_films = []
# films = ['Крепкий орешек', 'Назад в будущее', 'Таксист', 'Леон', 'Богемскаярапсодия',
#          'Город грехов', 'Мементо', 'Отступники', 'Деревня']
# for number in range(0,favoriate_films_count):
#     favoriate_film = input("Введите название фильма: ")
#     if favoriate_film in films:
#         favoriate_films.append(favoriate_film)
#     else: print(f"Ощибка: фильма {favoriate_film} у нас нет :(")    
# print(f"Ваш список любимых фильмов: {str(favoriate_films)[1:-1].translate({39: None})}")

# Task 3
# array = [1, 4, -3, 0, 10]
# print(f"Изначальный список: {array}")
# for i in range(len(array) - 1):
#     for j in range(len(array) - 1 - i):
#         if array[j] > array[j + 1]:
#             array[j], array[j + 1] = array[j + 1], array[j]
# print(f"Отсортированный список: {array}")

# Task 4
# goods = {
# 'Лампа': '12345',
# 'Стол': '23456',
# 'Диван': '34567',
# 'Стул': '45678',
# }
# store = {
# '12345': [
# {'quantity': 27, 'price': 42},
# ],
# '23456': [
# {'quantity': 22, 'price': 510},
# {'quantity': 32, 'price': 520},
# ],
# '34567': [
# {'quantity': 2, 'price': 1200},
# {'quantity': 1, 'price': 1150},
# ],
# '45678': [
# {'quantity': 50, 'price': 100},
# {'quantity': 12, 'price': 95},
# {'quantity': 43, 'price': 97},
# ],
# }
# store_sum = {}
# quantity_sum = 0
# price_sum = 0
# for key in goods.keys():
#     for dict in store[goods[key]]:
#         quantity_sum += list(dict.values())[0]
#         price_sum += list(dict.values())[0] * list(dict.values())[1]
#     store_sum[key] = {'quantity' : quantity_sum, 'price' : price_sum}
#     quantity_sum = 0
#     price_sum = 0
# for key in store_sum:
#     print(f"{key} --- {list(store_sum[key].values())[0]} штук,"
#           f" стоимость {list(store_sum[key].values())[1]} рубля")

# Task 5
# database = {} # Таблица пиццерии
# order_count = int(input("Введите количество заказов: "))
# for order_number in range(1,order_count + 1):
#     order_in_database_and_index = [False,0] # Есть ли уже заказ в таблице человека и индекс словаря с заказом
#     name_order_count = input(f"{order_number}-й заказ: ").split() # Имя-заказ-количество заказа
#     name = name_order_count[0] # Имя
#     order = name_order_count[1] # Заказ
#     count = int(name_order_count[2]) # Количество заказа
#     if name in database:
#         for dict in database[name]:
#             if order in list(dict.keys()):
#                 order_in_database_and_index = [True,database[name].index(dict)]
#                 break
#         if order_in_database_and_index[0]:
#             database[name][order_in_database_and_index[1]][order] += count
#         else:
#             database[name].append( {order : count} )
#     else:
#         database[name] = [ {order : count} ]
# for key,value in database.items():
#     print(f"{key}:")
#     for order in value:
#         print(f"{list(order.keys())[0]}: {list(order.values())[0]}")
#     print()      