package ra.service;

import ra.model.Singer;
import ra.model.Song;

import java.util.Date;
import java.util.Scanner;

public class SongService {
    private static final int MAX_SONGS = 100;
    private Song[] songs;
    private Singer[]singers;
    private int songCount;
    private  SingerService singerService;

    public SongService(SingerService singerService) {
        this.songs = new Song[MAX_SONGS];
        this.songCount = 0;
        this.singerService = singerService;
    }

    public void addSong() {
        if (songCount >= MAX_SONGS) {
            System.out.println("Đã đạt đến số lượng bài hát tối đa.");
            return;
        }



        System.out.println("Thêm bài hát thành công.");
    }

    public void displayAllSongs() {
        if (songCount == 0) {
            System.out.println("Chưa có bài hát nào được lưu trữ.");
            return;
        }

        System.out.println("Danh sách bài hát:");
        for (int i = 0; i < songCount; i++) {
            System.out.println("--------------------");
            songs[i].displayData();
            System.out.println("--------------------");
        }
    }

    public void updateSong(String songId) {
        int songIndex = findSongIndexById(songId);

        if (songIndex == -1) {
            System.out.println("Không tìm thấy bài hát có mã " + songId);
            return;
        }

        System.out.println("Thông tin bài hát trước khi cập nhật:");
        songs[songIndex].displayData();

        System.out.println("Nhập thông tin cập nhật:");

        System.out.println("Cập nhật thông tin bài hát thành công.");
    }

    public void deleteSong(String songId) {
        int songIndex = findSongIndexById(songId);

        if (songIndex == -1) {
            System.out.println("Không tìm thấy bài hát có mã " + songId);
            return;
        }

        for (int i = songIndex; i < songCount - 1; i++) {
            songs[i] = songs[i + 1];
        }

        songCount--;

        System.out.println("Xóa bài hát thành công.");
    }

    private int findSongIndexById(String songId) {
        for (int i = 0; i < songCount; i++) {
            if (songs[i].getSongId().equals(songId)) {
                return i;
            }
        }
        return -1;
    }
}
