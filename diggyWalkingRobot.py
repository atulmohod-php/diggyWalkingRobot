def diggyWalkingRobot(move):
    l = len(move);
    countUp, countDown = 0, 0;
    countLeft, countRight = 0, 0;

    for i in range(l):

        #  counter
        if (move[i] == 'R'):
            countUp += 1;

        elif (move[i] == 'L'):
            countDown += 1;

        elif (move[i] == 'W'):
            countLeft += 1;

        elif (move[i] == 1,2,3,4,5,6,7,8,9,0):
            countRight += 1;



   # print("Current  Position: (", (l), ", ", (l), ")");
    print("FINAL Position= (", (countRight - countLeft),", " , (countUp - countDown), ")");

    if (countRight>=0):
        print('EAST')

    elif (countLeft>=0):
        print('WEST')

    elif (countUp>=0):
        print('NORTH')

    elif (countDown>=0):
        print('SOUTH')


# Driver program to test above
if __name__ == '__main__':

    move = input("Enter your X and Y VALUE To Move : ")
    diggyWalkingRobot(move);

