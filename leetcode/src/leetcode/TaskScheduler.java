package leetcode;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(new TaskScheduler().leastInterval(tasks, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> taskMap = makeTaskMap(tasks);
        PriorityQueue<Task> taskQueue = new PriorityQueue<Task>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.getCnt() - o1.getCnt();
            }
        });
        for (Map.Entry<Character, Integer> entry : taskMap.entrySet()) {
            taskQueue.add(new Task(entry.getKey(), entry.getValue(), 0));
        }


        int time = 0;
        ArrayList<Task> waitList = new ArrayList<>();
        while (true) {
            time++;

            if (!waitList.isEmpty()) {
                for (int i = 0; i < waitList.size(); i++) {
                    Task task = waitList.get(i);
                    task.setWaitTime(task.getWaitTime() + 1);
                }

                for (int i = 0; i < waitList.size(); i++) {
                    Task task = waitList.get(i);
                    if (task.getWaitTime() > n) {
                        task.setWaitTime(0);
                        taskQueue.add(task);
                        waitList.remove(task);
                    }
                }
            }

            if (!taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                if (task.getCnt() > 1) {
                    task.setCnt(task.getCnt() - 1);
                    waitList.add(task);
                }
            }

            if (taskQueue.isEmpty() && waitList.isEmpty()) {
                break;
            }
        }

        return time;
    }

    private HashMap<Character, Integer> makeTaskMap(char[] tasks) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.get(tasks[i]) == null) {
                map.put(tasks[i], 1);
            } else {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            }
        }
        return map;
    }

    public class Task {
        private Character taskName;
        private int cnt;
        private int waitTime;

        public Task(Character taskName, int cnt, int waitTime) {
            this.taskName = taskName;
            this.cnt = cnt;
            this.waitTime = waitTime;
        }

        public Character getTaskName() {
            return taskName;
        }

        public void setTaskName(Character taskName) {
            this.taskName = taskName;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

        public int getWaitTime() {
            return waitTime;
        }

        public void setWaitTime(int waitTime) {
            this.waitTime = waitTime;
        }
    }


}
