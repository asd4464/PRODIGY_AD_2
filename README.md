# PRODIGY_AD_2
# To-Do List App

A simple Android application that allows users to manage their daily tasks. Users can add, edit, and delete tasks using this app. The app is built using Java and Android Studio, with SQLite as the database for storing tasks locally.

## Features

- **Add Tasks**: Users can add new tasks to their to-do list.
- **Edit Tasks**: Users can edit existing tasks.
- **Delete Tasks**: Users can remove tasks from their list.
- **Persistent Storage**: Tasks are stored locally in an SQLite database, so they persist across app restarts.

## Screenshots

![To-Do List Screenshot](screenshots/todo_list_screenshot.png)

## Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/ToDoListApp.git
    ```

2. **Open the project in Android Studio:**

    - Launch Android Studio.
    - Select **File > Open**.
    - Navigate to the cloned repository and open it.

3. **Build and run the project:**

    - Connect your Android device or start an emulator.
    - Click **Run** in Android Studio to install the app on your device/emulator.

## Usage

- **Adding a Task**: Tap the "Add Task" button, enter the task details in the dialog, and tap "Save".
- **Editing a Task**: Tap on a task from the list, modify the task details, and tap "Save".
- **Deleting a Task**: Long press on a task from the list to delete it.

## Project Structure

- **MainActivity.java**: Handles the main logic of the app, including displaying the list of tasks and handling user interactions.
- **DBHelper.java**: Manages the SQLite database operations like inserting, updating, and deleting tasks.
- **activity_main.xml**: Defines the layout for the main activity, including the ListView and the "Add Task" button.
- **dialog_add_edit_task.xml**: Defines the layout for the dialog used to add or edit tasks.

## Contributing

If you'd like to contribute to this project, please fork the repository and use a feature branch. Pull requests are warmly welcome.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries or feedback, please reach out at [your-email@example.com](mailto:your-email@example.com).
