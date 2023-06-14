package ra.service;

import ra.model.Singer;

import java.util.Scanner;

public class SingerService {
    private static final int MAX_SINGERS = 100;
    private Singer[] singers;
    private int singerCount;

    public SingerService() {
        this.singers = new Singer[MAX_SINGERS];
        this.singerCount = 0;
    }

    public void addSinger() {
        if (singerCount >= MAX_SINGERS) {
            System.out.println("Đã đạt đến số lượng ca sĩ tối đa.");
            return;
        }

        Singer singer = new Singer();
        singer.inputData();

        singers[singerCount] = singer;
        singerCount++;

        System.out.println("Thêm ca sĩ thành công.");
    }

    public void displayAllSingers() {
        if (singerCount == 0) {
            System.out.println("Chưa có ca sĩ nào được lưu trữ.");
            return;
        }

        System.out.println("Danh sách ca sĩ:");
        for (int i = 0; i < singerCount; i++) {
            System.out.println("--------------------");
            singers[i].displayData();
            System.out.println("--------------------");
        }
    }

    public void updateSinger(int singerId) {
        int singerIndex = findSingerIndexById(singerId);

        if (singerIndex == -1) {
            System.out.println("Không tìm thấy ca sĩ có mã " + singerId);
            return;
        }

        System.out.println("Thông tin ca sĩ trước khi cập nhật:");
        singers[singerIndex].displayData();

        System.out.println("Nhập thông tin cập nhật:");
        singers[singerIndex].inputData();

        System.out.println("Cập nhật thông tin ca sĩ thành công.");
    }

    public void deleteSinger(int singerId) {
        int singerIndex = findSingerIndexById(singerId);

        if (singerIndex == -1) {
            System.out.println("Không tìm thấy ca sĩ có mã " + singerId);
            return;
        }



        for (int i = singerIndex; i < singerCount - 1; i++) {
            singers[i] = singers[i + 1];
        }

        singerCount--;

        System.out.println("Xóa ca sĩ thành công.");
    }

    private int findSingerIndexById(int singerId) {
        for (int i = 0; i < singerCount; i++) {
            if (singers[i].getSingerId() == singerId) {
                return i;
            }
        }
        return -1;
    }
}
