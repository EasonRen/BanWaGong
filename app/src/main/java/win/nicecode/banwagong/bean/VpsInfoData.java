package win.nicecode.banwagong.bean;

/**
 * Created by Eason.Ren on 5/10/2018 15:49
 * Email: eason.ren@outlook.com
 */
public class VpsInfoData {
    private int id;
    private String veid;
    private String api_key;
    private String hostname;
    private String node_ip;
    private String node_alias;
    private String node_location;
    private String plan;
    private String plan_monthly_data;
    private String plan_disk;
    private String plan_ram;
    private String plan_swap;
    private String os;
    private String email;
    private String data_counter;
    private String data_next_reset;
    private String ip_address;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVeid() {
        return veid;
    }

    public void setVeid(String veid) {
        this.veid = veid;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getNode_ip() {
        return node_ip;
    }

    public void setNode_ip(String node_ip) {
        this.node_ip = node_ip;
    }

    public String getNode_alias() {
        return node_alias;
    }

    public void setNode_alias(String node_alias) {
        this.node_alias = node_alias;
    }

    public String getNode_location() {
        return node_location;
    }

    public void setNode_location(String node_location) {
        this.node_location = node_location;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getPlan_monthly_data() {
        return plan_monthly_data;
    }

    public void setPlan_monthly_data(String plan_monthly_data) {
        this.plan_monthly_data = plan_monthly_data;
    }

    public String getPlan_disk() {
        return plan_disk;
    }

    public void setPlan_disk(String plan_disk) {
        this.plan_disk = plan_disk;
    }

    public String getPlan_ram() {
        return plan_ram;
    }

    public void setPlan_ram(String plan_ram) {
        this.plan_ram = plan_ram;
    }

    public String getPlan_swap() {
        return plan_swap;
    }

    public void setPlan_swap(String plan_swap) {
        this.plan_swap = plan_swap;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_counter() {
        return data_counter;
    }

    public void setData_counter(String data_counter) {
        this.data_counter = data_counter;
    }

    public String getData_next_reset() {
        return data_next_reset;
    }

    public void setData_next_reset(String data_next_reset) {
        this.data_next_reset = data_next_reset;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
