package ra.controller;

import ra.service.SongService;

import java.util.Scanner;

public class SongController {
    private SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    public void displaySongManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới.");
            System.out.println("2. Hiển thị danh sách tất cả bài hát đã lưu trữ.");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id.");
            System.out.println("4. Xóa bài hát theo mã id.");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSongs();
                    break;
                case 2:
                    displayAllSongs();
                    break;
                case 3:
                    updateSong();
                    break;
                case 4:
                    deleteSong();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private void addSongs() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng bài hát cần thêm: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi đọc số

        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin bài hát thứ " + (i + 1) + ":");
            songService.addSong();
        }
    }

    private void displayAllSongs() {
        songService.displayAllSongs();
    }

    private void updateSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã bài hát cần cập nhật: ");
        String songId = scanner.nextLine();

        songService.updateSong(songId);
    }

    private void deleteSong() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã bài hát cần xóa: ");
        String songId = scanner.nextLine();

        songService.deleteSong(songId);
    }
}
