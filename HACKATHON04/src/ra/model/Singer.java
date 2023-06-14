package ra.model;

import java.util.Scanner;

public class Singer {
    private static int nextId = 1;

    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
        this.singerId = nextId++;
    }

    public int getSingerId() {
        return singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên ca sĩ: ");
        singerName = scanner.nextLine();

        System.out.print("Nhập tuổi: ");
        age = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập quốc tịch: ");
        nationality = scanner.nextLine();

        System.out.print("Nhập giới tính (Nam: true, Nữ: false): ");
        gender = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Nhập thể loại: ");
        genre = scanner.nextLine();
    }

    public void displayData() {
        System.out.println("Mã ca sĩ: " + singerId);
        System.out.println("Tên ca sĩ: " + singerName);
        System.out.println("Tuổi: " + age);
        System.out.println("Quốc tịch: " + nationality);
        System.out.println("Giới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("Thể loại: " + genre);
    }
}
