class Project:
    def __init__(self, name, duration):
        self.name = name
        self.duration = duration
        self.tasks = []
        self.ressources = []
        self.tracking = []

    def __repr__(self) -> str:
        return 'Project: name: ' + self.name + ', duration: ' + str(self.duration)

    def add_ressource(self, person):
        self.ressources.append(person)

    def add_task(self, task):
        self.tasks.append(task)

    def add_progression(self, date, who, task, workload, comment):
        self.tracking.append(Track(date=date, who=who, task=task, workload=workload, comment=comment))
        task.realized += workload
        task.remaining = task.actual - task.realized
        task.progress = task.realized / task.actual * 100

    def sum_workload_per_ressource(self):
        sum = {}
        for ressource in self.ressources:
            workload = 0
            for track in self.tracking:
                if ressource == track.who:
                    workload += track.workload
            print("\n")
            sum[ressource] = workload
        return sum

    def sum_workload_per_task(self):
        sum = {}
        for task in self.tasks:
            workload = 0
            for track in self.tracking:
                if task == track.what:
                    workload += track.workload
            sum[task] = workload
        return sum

    def print_summary(self):
        res = ""
        res += repr(self) + '\nResources in this project :\n'
        res += "{:15}{:15}".format("id", "name") + "\n"
        for ressource in self.ressources:
            res += "{:15}{:15}".format(ressource.id, ressource.name) + "\n"
        res += '\n\n'
        res += "All tasks\n"
        res += "{:<15}{:<40}{:>15}{:>15}{:>15}{:>15}{:>15}".format("id", "desc", "load", "actual", "realized",
                                                                   "remaining", "progress") + "\n"
        for task in self.tasks:
            res += repr(task) + "\n"
        res += "\nSum of workload per resource\n"
        works = self.sum_workload_per_ressource()
        res += "{:40}{:40}".format("Resource:", "Workload:") + "\n"
        for key in works.keys():
            res += "{:40}{:40}\n".format(key.id, str(works[key]))
        res += "\n\nSum of workload per task\n"
        work_task = self.sum_workload_per_task()
        res += "{:40}{:40}".format("Task:", "Workload:") + "\n"
        for key in work_task.keys():
            res += "{:40}{:40}".format(key.id, str(work_task[key])) + "\n"
            # res += key.id + " -> " + str(work_task[key]) + " j/h; \n "
        res += "\n"

        res += "\nTracking: \n"
        res += "{:<15}{:<15}{:<15}{:<15}{:15}".format("Date", "Who", "Task", "Workload", "Comment") + "\n"
        for track in self.tracking:
            res += repr(track) + '\n'

        print(res)


class Ressource:
    def __init__(self, id, name):
        self.id = id
        self.name = name

    def __repr__(self) -> str:
        return ' id: ' + self.id

    def print_detail(self):
        return 'Ressource => id: ' + self.id + ', name: ' + self.name


class Task:
    def __init__(self, id, desc, load, actual):
        self.id = id
        self.desc = desc
        self.load = load
        self.actual = actual
        self.realized = 0
        self.remaining = 0
        self.progress = 0

    def __repr__(self) -> str:
        return "{:<15}{:<40}{:>15}{:>15}{:>15}{:>15}{:>15}".format(self.id, self.desc, self.load, self.actual,
                                                                   "%.2f" % self.realized, "%.2f" % self.remaining,
                                                                   "%.2f" % self.progress + "%")


class Track:
    def __init__(self, date, who, task, workload, comment):
        self.date = date
        self.who = who
        self.what = task
        self.workload = workload
        self.comment = comment

    def __repr__(self):
        return "{:<15}{:<15}{:<15}{:<15}{:>15}".format(self.date, self.who.id, self.what.id, self.workload,
                                                       self.comment)
