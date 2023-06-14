package ra.controller;

import ra.model.Singer;
import ra.service.SingerService;

import java.util.Scanner;

public class SingerController {
    private SingerService singerService;

    public SingerController(SingerService singerService) {
        this.singerService = singerService;
    }

    public void displaySingerManagementMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới.");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ.");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id.");
            System.out.println("4. Xóa ca sĩ theo mã id.");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSingers();
                    break;
                case 2:
                    displayAllSingers();
                    break;
                case 3:
                    updateSinger();
                    break;
                case 4:
                    deleteSinger();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private void addSingers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng ca sĩ cần thêm: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự newline sau khi đọc số

        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin ca sĩ thứ " + (i + 1) + ":");
            singerService.addSinger();
        }
    }

    private void displayAllSingers() {
        singerService.displayAllSingers();
    }

    private void updateSinger() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã ca sĩ cần cập nhật: ");
        int singerId = scanner.nextInt();

        singerService.updateSinger(singerId);
    }

    private void deleteSinger() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã ca sĩ cần xóa: ");
        int singerId = scanner.nextInt();

        singerService.deleteSinger(singerId);
    }
}
