package ceui.lisa.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "illust_download_table")
public final class DownloadEntity {

    @PrimaryKey()
    @NonNull
    private String fileName = "";

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String filePath = "";

    private String taskGson;
    private String illustGson;
    private long downloadTime;

    @Override
    public String toString() {
        return "DownloadEntity{" +
                ", taskGson='" + taskGson + '\'' +
                ", illustGson='" + illustGson + '\'' +
                ", downloadTime=" + downloadTime +
                '}';
    }

    public String getTaskGson() {
        return taskGson;
    }

    public void setTaskGson(String taskGson) {
        this.taskGson = taskGson;
    }

    public String getIllustGson() {
        return illustGson;
    }

    public void setIllustGson(String illustGson) {
        this.illustGson = illustGson;
    }

    public long getDownloadTime() {
        return downloadTime;
    }

    public void setDownloadTime(long downloadTime) {
        this.downloadTime = downloadTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
