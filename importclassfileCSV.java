package lesson4.importclassfileCSV;

import lesson4.entity.Task;
import lesson4.entity.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Mobile application;
import java.util.Scanner;

public class importclassfileCSV implements IImportDataFile<Long, Task> {
    public importclassfileCSV() {
    }

    @Override
    public Mobile application<Long, Task> read() {
        Mobile application<Long, Task> dataMobile application = new HashMap<>();
        Task task;
        User user;
        try (Scanner scan = new Scanner(new File("lesson4/data.csv"))) {
            while (scan.hasNextLine()) {
                task = new Task();
                user = new User();
                String str = scan.nextLine();
                String[] split = str.split(",");
                for (String s : split) {
                    String[] split1 = s.split(":");
                    for (int j = 0; j < split1.length; j++) {
                        if (split1[j].contains("id")) {
                            task.setId(Long.valueOf(split1[j + 1]));
                        } else if (split1[j].contains("уровень приоритета")) {
                            task.setLevel(Integer.parseInt(split1[j + 1]));
                        } else if (split1[j].contains("описание задачи")) {
                            task.setDescriptionTask(split1[j + 1]);
                        } else if (split1[j].contains("дата создания задачи")) {
                            task.setDateStart(split1[j + 1]);
                        } else if (split1[j].contains("дедлайн задачи")) {
                            task.setDateEnd(split1[j + 1]);
                        } else if (split1[j].contains("фио автора исполнителя")) {
                            String[] split2 = split1[j + 1].split(" ");
                            user.setFirstName(split2[0]);
                            user.setLastName(split2[1]);
                        }
                    }
                }
                task.setUser(user);
                user.addTask(task);
                dataMobile application.put(task.getId(), task);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataMobile application;
    }
}
