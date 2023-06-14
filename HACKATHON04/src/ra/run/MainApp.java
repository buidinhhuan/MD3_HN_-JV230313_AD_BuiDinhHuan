package ra.run;

import ra.controller.SingerController;
import ra.controller.SongController;
import ra.service.SingerService;
import ra.service.SongService;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        SingerService singerService = new SingerService();
        SongService songService = new SongService(singerService);

        SingerController singerController = new SingerController(singerService);
        SongController songController = new SongController(songService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**********************RECORD-APP*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Thoát");
            System.out.print("Nhâp lựa chọn : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    singerController.displaySingerManagementMenu();
                    break;
                case 2:
                    songController.displaySongManagementMenu();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}

