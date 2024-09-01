public class MainActivity extends AppCompatActivity {

    private ListView listViewTasks;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> taskList;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTasks = findViewById(R.id.listViewTasks);
        dbHelper = new DBHelper(this);

        loadTasks();

        findViewById(R.id.btnAddTask).setOnClickListener(v -> showAddTaskDialog());
        listViewTasks.setOnItemClickListener((parent, view, position, id) -> showEditDeleteTaskDialog(position));
    }

    private void loadTasks() {
        taskList = new ArrayList<>();
        Cursor cursor = dbHelper.getAllTasks();
        while (cursor.moveToNext()) {
            taskList.add(cursor.getString(cursor.getColumnIndexOrThrow("task_name")));
        }
        cursor.close();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(adapter);
    }

    private void showAddTaskDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_edit_task);
        EditText editTextTask = dialog.findViewById(R.id.editTextTask);
        Button btnSaveTask = dialog.findViewById(R.id.btnSaveTask);

        btnSaveTask.setOnClickListener(v -> {
            String task = editTextTask.getText().toString();
            if (!task.isEmpty()) {
                dbHelper.insertTask(task);
                loadTasks();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showEditDeleteTaskDialog(final int position) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_edit_task);
        EditText editTextTask = dialog.findViewById(R.id.editTextTask);
        Button btnSaveTask = dialog.findViewById(R.id.btnSaveTask);

        editTextTask.setText(taskList.get(position));

        btnSaveTask.setOnClickListener(v -> {
            String newTask = editTextTask.getText().toString();
            if (!newTask.isEmpty()) {
                long id = getTaskId(position);
                dbHelper.updateTask(id, newTask);
                loadTasks();
                dialog.dismiss();
            }
        });

        dialog.setOnLongClickListener(v -> {
            long id = getTaskId(position);
            dbHelper.deleteTask(id);
            loadTasks();
            dialog.dismiss();
            return true;
        });

        dialog.show();
    }

    private long getTaskId(int position) {
        Cursor cursor = dbHelper.getAllTasks();
        cursor.moveToPosition(position);
        long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        cursor.close();
        return id;
    }
}
