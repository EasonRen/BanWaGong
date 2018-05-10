package win.nicecode.banwagong.bean;

import java.util.List;

/**
 * Created by Eason.Ren on 5/7/2018 10:11
 * Email: eason.ren@outlook.com
 */
public class AvailableOS {

    /**
     * error : 0
     * installed : ubuntu-16.04-x86_64
     * templates : ["ubuntu-15.10-x86_64-minimal","ubuntu-16.04-x86_64"]
     */

    private int error;
    private String installed;
    private List<String> templates;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getInstalled() {
        return installed;
    }

    public void setInstalled(String installed) {
        this.installed = installed;
    }

    public List<String> getTemplates() {
        return templates;
    }

    public void setTemplates(List<String> templates) {
        this.templates = templates;
    }
}
