def distance(point_1, point_2):
    return sqrt((point_1[0]-point_2[0])**2 + (point_1[1]-point_2[1])**2)


A = (60, 70)
B = (20, 10)
C = (80, 3)
D = (30, 80)
E = (70, 90)
F = (4, 8)
G = (15, 65)
H = (90, 25)
I = (7, 5)
J = (3, 3)

centre_1 = (50, 70)
centre_2 = (80, 70)
centre_3 = (50, 90)


points = [A, B, C, D, E, F, G, H, I, J]
centres = [centre_1, centre_2, centre_3]
distances = [[], [], [], [], [], [], [], [], [], []] # i : points; j : centres

groupes = [[]] # i : centres ; j : points
means = [] # i : centres

anciens_centre = [(0, 0), (0, 0), (0, 0)]

while anciens_centre != centres :
    # Calcul de la distance entre les points et les centres
    for i in range(len(points)):
        for j in range(len(centres)):
            distances[i][j].append(distance(points[i], centres[j]))


    # Calcul de la distance mininum entre les centres et les points
    for i in range(len(distances)):
        minimum = distances[i][0]
        minimum_index = (i, 0)
        for j in range(len(distances[i])):
            if minimum > distances[i][j]:
                minimum = distances[i][j]
                minimum_index = (i, j)
                groupes[j].append(points[i])


    # Calcul de la moyenne des points dans les groupes : 
    for i in range(len(groupes)):
        means[i] = 0
        for j in range(len(groupes[i])):
            means[i] += groupes[i][j]
        means[i] = means[i]/len(groupes[i])

    # Mise à jour des centres :
    anciens_centre = centres
    centres = means



