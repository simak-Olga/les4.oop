package lesson4.importclassfileCSV2;

import lesson4.TaskComparator
import lesson4.entity.Task;
import lesson4.repository.TaskRepository;

import java. io. FileWriter;
import java. io. IoException;
import java.util.List;

public class importclassfileCSV2 implements IImportDataFile2<TaskRepository> {
    public importclassfileCSV2() {
    }

    public void write(TaskRepository repository) {
        try (FileWriter writer = new FileWriter("lesson4/data.csv",true)) {
            StringBuilder sBuilder = new StringBuilder();
            List<Task> tasks= repository.readAllTasks();
            tasks. sort(new TaskComparator());
            for (Task tasks  : tasks) {
                sBuilder. append(id:"). append(задача. getId()). append((",");
                sBuilder. append("уровень приоритета:"). append(task. getLevel()). append((",");
                sBuilder. append("описание задачи:"). append(task. getDescriptionTask()). append((",");
                sBuilder. append("дата создания задачи:"). append(task. getDateStart()). append((",");
                sBuilder. append("дедлайн задачи:"). append(task. getDateEnd()). append((",");
                sBuilder. append("фио автора исполнителя:"). append(task. getUser(). getFullName()). append("\n");
            }
            writer. write(sBuilder. toString());
            writer. flush();
        } catch (IOException e) {
           System.out.println(e. getMessage());
        }
    }
