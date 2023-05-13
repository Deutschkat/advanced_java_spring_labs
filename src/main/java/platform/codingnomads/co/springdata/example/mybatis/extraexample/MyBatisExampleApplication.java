package platform.codingnomads.co.springdata.example.mybatis.extraexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ChapterMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.ImageMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.LessonMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.mappers.SectionMapper;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Chapter;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Image;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Lesson;
import platform.codingnomads.co.springdata.example.mybatis.extraexample.models.Section;

@SpringBootApplication
public class MyBatisExampleApplication implements CommandLineRunner {

    /* Before running this app, be sure to:

        * create a new empty schema in the mysql database named "mybatis"

        * execute the SQL found "database_structure.sql" on the mybatis schema

        * update the "spring.datasource.url" property in your application.properties file to
          jdbc:mysql://localhost:3306/mybatis?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC

     */

    @Autowired
    ImageMapper imageMapper;

    @Autowired
    LessonMapper lessonMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    SectionMapper sectionMapper;

    public static void main(String[] args) {
        SpringApplication.run(MyBatisExampleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {


        // create section
        sectionMapper.insertNewSection("SectionOne");
        System.out.println("Section one created.");
        // read section
        Section section = sectionMapper.getSectionById(1L);
        if (section != null) {
            System.out.println("Section retrieved: " + section.getName());
        } else {
            System.out.println("No section found with the provided id.");
        }
        // delete section
        sectionMapper.deleteSectionById(1L);
        System.out.println("Section deleted.");




        // create chapter
        chapterMapper.insertNewChapter("ChapterOne", 1L);
        System.out.println("ChapterOne inserted.");
        // read chapter
        Chapter chapter = chapterMapper.getByChapterId(1L);
        System.out.println("Chapter retrieved: " + chapter.getName());
        // delete chapter
        chapterMapper.deleteChapterById(1L);
        System.out.println("Chapter deleted.");




        // create lesson
        lessonMapper.insertNewLesson("LessonOne", "TextEx", 1L);
        System.out.println("LessonOne inserted.");

        // read lesson
        Lesson lesson = lessonMapper.getLessonById(1L);
        System.out.println("Lesson retrieved: " + lesson.getName());
        // delete lesson
        lessonMapper.deleteLessonById(1L);
        System.out.println("Lesson deleted.");



        // create image
        byte[] imageData = new byte[] {0, 2, 3};
        imageMapper.insertNewImage("PictureOne", imageData);
        System.out.println("PictureOne inserted.");

        // read image
        Image image = imageMapper.getImageByName("PictureOne");
        System.out.println("Image retrieved: " + image.getName());

        // update image
        imageMapper.updateImageByName("Image1", "NewData");
        System.out.println("Image updated.");

        // delete image
        imageMapper.deleteImageByName("Image1");
        System.out.println("Image deleted.");



    }



    }
