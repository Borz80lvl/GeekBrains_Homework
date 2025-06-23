# Task 1

site = {
'html': {
'head': {'title': 'Мой сайт'},
'body': {'h2': 'Здесь будет мой заголовок',
         'div': 'Тут, наверное, какой-то блок',
         'p': 'А вот здесь новый абзац'}
}
}


def find_key(dictionary, key, max_max_depth=0, user_max_depth=1):
    if max_depth and max_max_depth < user_max_depth:
        return None
    if key in dictionary.keys():
        return dictionary[key]
    value = None
    for element in dictionary.values():
        if type(element) == dict:
            value = find_key(element, key,max_max_depth,user_max_depth + 1)
            if value:
                break
    return value


user_key = input("Введите искомый ключ: ")
yes_or_no = input("Хотите ввести максимальную глубину? Y/N: ").lower()
if yes_or_no == "y":
    max_depth = int(input("Введите максимальную глубину: "))
else:
    max_depth = 0
print(f"Значение ключа: {find_key(site, user_key, max_depth)}")

# Task 2
# import copy
# site = {
# 'html': {
# 'head': {'title': 'Куплю/продам {0} недорого'},
# 'body': {'h2': 'У нас самая низкая цена на {0}',
#         'div': 'Купить',
#         'p': 'Продать'}
# }
# }
# sites = []
# 
# 
# def site_generator(site: dict,produkt):
#     site_clon = copy.deepcopy(site)
#     site_clon['html']['head']['title'] = f'Куплю/продам {produkt} недорого'
#     site_clon['html']['body']['h2'] = f'У нас самая низкая цена на {produkt}'
#     sites.append(site_clon)
#     site_clon = 0
# 
# 
# site_count = int(input("Сколько сайтов: "))
# for count in range(site_count):
#     produkt = input("Введите название продукта для нового сайта:")
#     site_generator(site,produkt)
#     print(f"Сайт для {produkt}")
#     for site in sites:
#         print(site)

# Task 3
# array = [[1, 2, [3]], [1], 3]
# numbers = [1, 2 ,3 ,4 ,5]
# 
# 
# def sum(*args):
#     result = 0
#     for item in args:                                               
#         if isinstance(item, int):
#             result += item
#         else:
#             for element in item:
#                 result += sum(element)
#     return result
# 
# 
# print(sum(array))
# print(sum(numbers))

# Task 4
# nice_list = [1, 2, [3, 4], [[5, 6, 7], [8, 9, 10]],
#              [[11, 12, 13], [14, 15], [16, 17, 18]]]
# # 
# # 
# def list_opener(array):
#     open_list = []
#     for list in array:
#         if isinstance(list, int):
#             open_list.append(list)
#         else:
#             open_list.extend(list_opener(list))
#     return open_list
# # 
# # 
# print(list_opener(nice_list))