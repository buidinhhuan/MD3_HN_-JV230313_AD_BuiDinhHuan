package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        this.songId = generateSongId();
        this.createdDate = new Date();
    }

    public String getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    private String generateSongId() {
        String prefix = "S";
        String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }

        return prefix + sb.toString();
    }

    public  void  inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên bài hát: ");
        songName = scanner.nextLine();

        System.out.print("Nhập mô tả bài hát: ");
        descriptions = scanner.nextLine();

        System.out.print("Nhập tên người sáng tác: ");
        songWriter = scanner.nextLine();

        System.out.println("Danh sách ca sĩ:");
        // Hiển thị danh sách ca sĩ để người dùng chọn
        // Cần có một đối tượng quản lý danh sách ca sĩ và phương thức để thêm, sửa, xóa ca sĩ

        // Lấy id của ca sĩ từ người dùng
        System.out.print("Nhập id ca sĩ: ");
        int singerId = Integer.parseInt(scanner.nextLine());

        // Tìm ca sĩ trong danh sách ca sĩ dựa trên id và gán vào thuộc tính singer
        // Nếu không tìm thấy ca sĩ, yêu cầu người dùng thêm ca sĩ trước
    }

    public void displayData() {
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Ca sĩ: " + singer.getSingerName());
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái: " + (songStatus ? "Hoạt động" : "Không hoạt động"));
    }
}
