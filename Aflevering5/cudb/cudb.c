// cudb.c

#include <stdio.h>
#include <string.h>

#define NAME_SIZE 5

typedef struct {
  char name[NAME_SIZE];
  int data;
} student_t;

// Universelle variable
int b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, year, gpa;
char name[5];
int cnt = 0;
student_t dataBase[10000];

// Følgende 2 metoder: Fra decimal til bits
int yearBits(int d) {
    b0 = d % 2;
    b1 = (d / 2) % 2;
    b2 = (d / 4) % 2;
    b3 = (d / 8) % 2;
    b4 = (d / 16) % 2;
}

int gpaBits(int d) {
    b6 = d % 2;
    b7 = (d / 2) % 2;
    b8 = (d / 4) % 2;
    b9 = (d / 8) % 2;
    b10 = (d / 16) % 2;
    b11 = (d / 32) % 2;
    b12 = (d / 64) % 2;
    b13 = (d / 128) % 2;
}

// Følgende 4 metoder: Modtager input og tjekker om det overholder kravene
int addName() {
    int check = 1;
    while (check == 1) {
        puts("\n Enter name (4 characters only):");
        scanf("%s", &name);
        if (name[0] == '\0' || name[1] == '\0' || name[2] == '\0' || name[3] == '\0' || name[4] != '\0') {
            puts("\n Invalid name! \n Please enter a name with 4 characters \n For further questions, please contact technical support");
        } else {
            check = 0;
        }
    }
}

int addYear() {
    int check = 1;
    while (check == 1) {
        puts("\n Enter start year (2009-2040):");
        scanf("%d", &year);
        if (year > 2040 || year < 2009) {
            puts("\n Invalid start year! \n Please enter a year between 2009 and 2040 \n If you started before 2009, please contact technical support");
        } else {
            yearBits(year - 2009);
            check = 0;
        }
    }
}

int addSemester() {
    int check = 1;
    while (check == 1) {
        puts("\n Enter start semester (0 = Autumn / 1 = Spring):");
        scanf("%d", &b5);
        if (b5 == 1 || b5 == 0) {
            check = 0;
        } else {
            puts("\n Invalid start semester! \n Please enter your start semester (0 = Autumn / 1 = Spring) \n For further questions, please contact technical support");
        }
    }
}

int addGPA() {
    int check = 1;
    while (check == 1) {
        puts("\n Enter GPA (0-255):");
        scanf("%d", &gpa);
        if (gpa > 255 || gpa < 0) {
            puts("\n Invalid GPA! \n Please enter your GPA, which is between 0 and 255 \n For further questions, please contact technical support");
        } else {
            gpaBits(gpa);
            check = 0;
        }
    }
}

// Sammensætter bits til decimal og tilføjer strukturen til arrayet
int studentConst() {
    int data = b0 + 2*b1 + 4*b2 + 8*b3 + 16*b4 + 32*b5 + 64*b6 + 128*b7 + 256*b8 + 512*b9 + 1024*b10 + 2048*b11 + 4096*b12 + 8192*b13;
    student_t theStudent;
    strncpy(theStudent.name, name, 5);
    theStudent.data = data;
    dataBase[cnt] = theStudent;
    cnt = cnt + 1;
}

// Forløbige metoder sat sammen
int addStudent() {
    addName();
    addYear();
    addSemester();
    addGPA();
    studentConst();
}

// Fra decimal til bits
int getBits(int d) {
    b0 = d % 2;
    b1 = (d / 2) % 2;
    b2 = (d / 4) % 2;
    b3 = (d / 8) % 2;
    b4 = (d / 16) % 2;
    b5 = (d / 32) % 2;
    b6 = (d / 64) % 2;
    b7 = (d / 128) % 2;
    b8 = (d / 256) % 2;
    b9 = (d / 512) % 2;
    b10 = (d / 1024) % 2;
    b11 = (d / 2048) % 2;
    b12 = (d / 4096) % 2;
    b13 = (d / 8192) % 2;
}

// Tjekker arrayet for indhold, genfinder dataen og printer den, stopper når der ikke er mere indhold, printer gennemsnittet
int listStudents() {
    int check = 1;
    int sum = 0;
    double average;
    while(check == 1) {
        for (int i = 0; i <= 9999; i++) {
            if (dataBase[i].name[0] == '\0' && i == 0) {
                puts("\n Error! \n There are currently no students registered in CUDB \n Please selected action 2 to add a new student to the database");
                check = 0;
            }else if (dataBase[i].name[0] == '\0') {
                check = 0;
            } else {
                getBits(dataBase[i].data);
                year = b0 + b1*2 + b2*4 + b3*8 + b4*16 + 2009;
                gpa = b6 + b7*2 + b8*4 + b9*8 + b10*16 + b11*32 + b12*64 + b13*128;
                sum = sum + gpa;
                average = sum / (i + 1);
                char semester[7];
                if (b5 == 1) {
                    strncpy(semester, "Spring", 7);
                } else {
                    strncpy(semester, "Autumn", 7);
                }
                printf("\n s%04d %s %d %s %d", i, dataBase[i].name, year, semester, gpa);
            }
        }
    }
    printf("\n \n Average GPA = %.2f \n", average);
}





int main() {
    puts("\n Welcome to CUDB - The C University Data Base \n \n 0: Halt \n 1: List all students \n 2: Add new student");
    int running = 1;
    while(running == 1) {
        puts("\n Enter action:");
        int act;
        scanf("%d", &act);
        if (act == 0) {
            puts("\n Bye");
            running = 0;
        } else if (act == 1) {
            listStudents();
        } else if (act == 2) {
            addStudent();
        } else {
            puts("\n Invalid action! \n Please choose an action from the following list: \n \n 0: Halt \n 1: List all students \n 2: Add new student");
        }
    }
    return 0;
}