
create table `TeachersCourse` (
    `course_id` int unsigned not null,
    `teacher_id` int unsigned not null,
    primary key (`course_id`, `teacher_id`))
    engine=InnoDB;
alter table `TeachersCourse`
add constraint `FKn25lj5i7x4f96i5w73dj91xk3`
foreign key (`course_id`)
references Courses (`id`);
alter table `TeachersCourse`
add constraint `FKndw5l3wkwu2khujnl06tnhl41`
foreign key (`teacher_id`)
references Teachers (`id`);

INSERT INTO
    `TeachersCourse` (`course_id`,`teacher_id`)
SELECT
    `Courses`.`id`,
    `Courses`.`teacher_id`
FROM
    `Courses`;

ALTER TABLE `Courses`
DROP FOREIGN KEY `teacher`;

ALTER TABLE `Courses`
DROP COLUMN `teacher_id`;