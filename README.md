


# Student Management System in Java

A simple **Student Management System** implemented in Java using **arrays**.  
This project allows the user to **load, add, search, display, and save students** in a text file. It includes a **menu-driven interface** and supports file I/O.

---

## Table of Contents

- [Features](#features)  
- [Prerequisites](#prerequisites)  
- [Project Structure](#project-structure)  
- [How to Run](#how-to-run)  
- [Usage](#usage)  
- [File Format](#file-format)  
- [Future Enhancements](#future-enhancements)  

---

## Features

- Load existing student data from a file on startup  
- Add new students manually  
- Search for a student by name  
- Display all students  
- Save the student list to a file  
- Menu-driven interface  
- Uses **arrays** only (no ArrayList) with dynamic resizing  

---

## Prerequisites

- Java JDK 8 or higher installed  
- Basic knowledge of running Java programs from terminal or IDE  

---

## Project Structure

```

StudentManagement/
├── Etudiant.java
├── Main.java
├── etudiants.txt       # Sample data file (optional)
└── README.md

````

- **Etudiant.java** – Class representing a student with attributes:
  - Name (`mNom`)  
  - Department (`mFiliere`)  
  - Average (`mMoyenne`)  
  - Age (`mAge`)  
- **Main.java** – Contains the menu system and file I/O logic  
- **etudiants.txt** – Optional file to pre-load student data  
- **README.md** – Project documentation  

---

## How to Run

1. Clone or download this repository:  
   ```bash
   git clone https://github.com/yourusername/StudentManagement.git
   cd StudentManagement
````

````
2. Compile the Java files:

   ```bash
   javac Etudiant.java Main.java
   ```

3. Run the program:

   ```bash
   java Main
   ```

---

## Usage

1. **Load file**: Enter the name of the student file to load at startup (e.g., `etudiants.txt`). If the file does not exist, an empty system is initialized.

2. **Menu Options**:

   * `1` – Add a new student
   * `2` – Search a student by name
   * `3` – Display all students
   * `4` – Save all students to file
   * `0` – Quit the program

3. **Adding Students**: Enter Name, Department, Average, and Age when prompted.

4. **Searching Students**: Enter the exact name of the student. The system will display the matching student if found.

5. **Saving**: All students in the system will be saved in the specified file in CSV format.

---

## File Format

The students are saved in **CSV format** (`Name,Department,Age,Average`).

Example:

```
Bryan,Informatique,20,15.5
Alice,Math,21,14.2
John,Physique,22,13.7
```

* **Name**: Student name
* **Department**: Student department/faculty
* **Age**: Integer value
* **Average**: Double value


## License

This project is open source and free to use for educational purposes.

---

## Author

 – GitHub: [ruiz00](https://github.com/ruiz00)

