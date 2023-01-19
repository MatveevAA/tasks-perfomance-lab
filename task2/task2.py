def get_input():
    """Указываем путь до файлов с исходными данными."""
    root_test1 = input('Укажите путь до test1: ')
    root_test2 = input('Укажите путь до test2: ')
    return root_test1, root_test2


def parse_file(root_test1: str, root_test2: str):
    """Получаем координаты точек из файлов."""
    points = []
    with open(root_test1) as test1:
        centre = list(map(float, test1.readline().strip().split()))
        x0, y0 = centre[0], centre[1]
        rad = int(test1.readline().strip().split()[0])
    with open(root_test2) as test2:
        while True:
            point = list(map(float, test2.readline().strip().split()))
            if point:
                points.append(point)
            else:
                break
    return x0, y0, rad, points


def is_in_circle(x0: float, y0: float, rad: int, point: list):
    """Проверяем в каком положении относительно окружности находится точка"""
    x1 = point[0]
    y1 = point[1]
    vector_length = (x1-x0) ** 2 + ((y1-y0) ** 2) ** 0.5
    if vector_length == rad:
        return 0
    elif vector_length < rad:
        return 1
    else:
        return 2


if __name__ == '__main__':
    root_test1, root_test2 = get_input()
    x0, y0, rad, points = parse_file(root_test1, root_test2)
    for point in points:
        ans = is_in_circle(x0, y0, rad, point)
        print(ans)