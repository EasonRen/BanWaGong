package win.nicecode.banwagong.bean;

import java.util.List;

public class LiveServiceInfo {

    /**
     * vm_type : ovz
     * vz_status : {"status":"running","hostname":"localhost.localdomain","load_average":"0.00/0.00/0.00","nproc":"37","nproc_b":"320","kmemsize":"9407163","kmemsize_b":"268435456","privvmpages":"83519","privvmpages_b":"524288","oomguarpages":"26004","oomguarpages_b":"131072","numtcpsock":"32","numtcpsock_b":"3010","numfile":"497","numfile_b":"20480","swappages":"13326","swappages_b":"16384","physpages":"18534","physpages_l":"131072"}
     * vz_quota : {"occupied_kb":"4061836","softlimit_kb":"10485760","hardlimit_kb":"11010048","occupied_inodes":"70511","softlimit_inodes":"10240000","hardlimit_inodes":"10752000"}
     * is_cpu_throttled :
     * ssh_port : 27490
     * hostname : localhost.localdomain
     * node_ip : 198.35.46.26
     * node_alias : v316
     * node_location : US, Arizona
     * node_location_id : USAZ_2
     * node_datacenter : US: Phoenix, Arizona
     * location_ipv6_ready : true
     * plan : wagon10g512m1t
     * plan_monthly_data : 1073741824000
     * monthly_data_multiplier : 1
     * plan_disk : 10737418240
     * plan_ram : 536870912
     * plan_swap : 67108864
     * plan_max_ipv6s : 3
     * os : ubuntu-16.04-x86_64
     * email : eason.ren@outlook.com
     * data_counter : 5953745238
     * data_next_reset : 1527307200
     * ip_addresses : ["104.224.139.217","2607:8700:103:a7e6::","2607:8700:103:a7e6:16c7:6f67:dbe8:a4ea"]
     * rdns_api_available : true
     * ptr : {"104.224.139.217":null,"2607:8700:103:a7e6::":"","2607:8700:103:a7e6:16c7:6f67:dbe8:a4ea":""}
     * suspended : false
     * error : 0
     * veid : 379833
     */

    private String vm_type;
    private VzStatusBean vz_status;
    private VzQuotaBean vz_quota;
    private String is_cpu_throttled;
    private int ssh_port;
    private String hostname;
    private String node_ip;
    private String node_alias;
    private String node_location;
    private String node_location_id;
    private String node_datacenter;
    private boolean location_ipv6_ready;
    private String plan;
    private long plan_monthly_data;
    private int monthly_data_multiplier;
    private long plan_disk;
    private int plan_ram;
    private int plan_swap;
    private int plan_max_ipv6s;
    private String os;
    private String email;
    private long data_counter;
    private int data_next_reset;
    private boolean rdns_api_available;
    private boolean suspended;
    private int error;
    private int veid;
    private List<String> ip_addresses;

    public String getVm_type() {
        return vm_type;
    }

    public void setVm_type(String vm_type) {
        this.vm_type = vm_type;
    }

    public VzStatusBean getVz_status() {
        return vz_status;
    }

    public void setVz_status(VzStatusBean vz_status) {
        this.vz_status = vz_status;
    }

    public VzQuotaBean getVz_quota() {
        return vz_quota;
    }

    public void setVz_quota(VzQuotaBean vz_quota) {
        this.vz_quota = vz_quota;
    }

    public String getIs_cpu_throttled() {
        return is_cpu_throttled;
    }

    public void setIs_cpu_throttled(String is_cpu_throttled) {
        this.is_cpu_throttled = is_cpu_throttled;
    }

    public int getSsh_port() {
        return ssh_port;
    }

    public void setSsh_port(int ssh_port) {
        this.ssh_port = ssh_port;
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

    public String getNode_location_id() {
        return node_location_id;
    }

    public void setNode_location_id(String node_location_id) {
        this.node_location_id = node_location_id;
    }

    public String getNode_datacenter() {
        return node_datacenter;
    }

    public void setNode_datacenter(String node_datacenter) {
        this.node_datacenter = node_datacenter;
    }

    public boolean isLocation_ipv6_ready() {
        return location_ipv6_ready;
    }

    public void setLocation_ipv6_ready(boolean location_ipv6_ready) {
        this.location_ipv6_ready = location_ipv6_ready;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public long getPlan_monthly_data() {
        return plan_monthly_data;
    }

    public void setPlan_monthly_data(long plan_monthly_data) {
        this.plan_monthly_data = plan_monthly_data;
    }

    public int getMonthly_data_multiplier() {
        return monthly_data_multiplier;
    }

    public void setMonthly_data_multiplier(int monthly_data_multiplier) {
        this.monthly_data_multiplier = monthly_data_multiplier;
    }

    public long getPlan_disk() {
        return plan_disk;
    }

    public void setPlan_disk(long plan_disk) {
        this.plan_disk = plan_disk;
    }

    public int getPlan_ram() {
        return plan_ram;
    }

    public void setPlan_ram(int plan_ram) {
        this.plan_ram = plan_ram;
    }

    public int getPlan_swap() {
        return plan_swap;
    }

    public void setPlan_swap(int plan_swap) {
        this.plan_swap = plan_swap;
    }

    public int getPlan_max_ipv6s() {
        return plan_max_ipv6s;
    }

    public void setPlan_max_ipv6s(int plan_max_ipv6s) {
        this.plan_max_ipv6s = plan_max_ipv6s;
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

    public long getData_counter() {
        return data_counter;
    }

    public void setData_counter(long data_counter) {
        this.data_counter = data_counter;
    }

    public int getData_next_reset() {
        return data_next_reset;
    }

    public void setData_next_reset(int data_next_reset) {
        this.data_next_reset = data_next_reset;
    }

    public boolean isRdns_api_available() {
        return rdns_api_available;
    }

    public void setRdns_api_available(boolean rdns_api_available) {
        this.rdns_api_available = rdns_api_available;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getVeid() {
        return veid;
    }

    public void setVeid(int veid) {
        this.veid = veid;
    }

    public List<String> getIp_addresses() {
        return ip_addresses;
    }

    public void setIp_addresses(List<String> ip_addresses) {
        this.ip_addresses = ip_addresses;
    }

    public static class VzStatusBean {
        /**
         * status : running
         * hostname : localhost.localdomain
         * load_average : 0.00/0.00/0.00
         * nproc : 37
         * nproc_b : 320
         * kmemsize : 9407163
         * kmemsize_b : 268435456
         * privvmpages : 83519
         * privvmpages_b : 524288
         * oomguarpages : 26004
         * oomguarpages_b : 131072
         * numtcpsock : 32
         * numtcpsock_b : 3010
         * numfile : 497
         * numfile_b : 20480
         * swappages : 13326
         * swappages_b : 16384
         * physpages : 18534
         * physpages_l : 131072
         */

        private String status;
        private String hostname;
        private String load_average;
        private String nproc;
        private String nproc_b;
        private String kmemsize;
        private String kmemsize_b;
        private String privvmpages;
        private String privvmpages_b;
        private String oomguarpages;
        private String oomguarpages_b;
        private String numtcpsock;
        private String numtcpsock_b;
        private String numfile;
        private String numfile_b;
        private String swappages;
        private String swappages_b;
        private String physpages;
        private String physpages_l;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        public String getLoad_average() {
            return load_average;
        }

        public void setLoad_average(String load_average) {
            this.load_average = load_average;
        }

        public String getNproc() {
            return nproc;
        }

        public void setNproc(String nproc) {
            this.nproc = nproc;
        }

        public String getNproc_b() {
            return nproc_b;
        }

        public void setNproc_b(String nproc_b) {
            this.nproc_b = nproc_b;
        }

        public String getKmemsize() {
            return kmemsize;
        }

        public void setKmemsize(String kmemsize) {
            this.kmemsize = kmemsize;
        }

        public String getKmemsize_b() {
            return kmemsize_b;
        }

        public void setKmemsize_b(String kmemsize_b) {
            this.kmemsize_b = kmemsize_b;
        }

        public String getPrivvmpages() {
            return privvmpages;
        }

        public void setPrivvmpages(String privvmpages) {
            this.privvmpages = privvmpages;
        }

        public String getPrivvmpages_b() {
            return privvmpages_b;
        }

        public void setPrivvmpages_b(String privvmpages_b) {
            this.privvmpages_b = privvmpages_b;
        }

        public String getOomguarpages() {
            return oomguarpages;
        }

        public void setOomguarpages(String oomguarpages) {
            this.oomguarpages = oomguarpages;
        }

        public String getOomguarpages_b() {
            return oomguarpages_b;
        }

        public void setOomguarpages_b(String oomguarpages_b) {
            this.oomguarpages_b = oomguarpages_b;
        }

        public String getNumtcpsock() {
            return numtcpsock;
        }

        public void setNumtcpsock(String numtcpsock) {
            this.numtcpsock = numtcpsock;
        }

        public String getNumtcpsock_b() {
            return numtcpsock_b;
        }

        public void setNumtcpsock_b(String numtcpsock_b) {
            this.numtcpsock_b = numtcpsock_b;
        }

        public String getNumfile() {
            return numfile;
        }

        public void setNumfile(String numfile) {
            this.numfile = numfile;
        }

        public String getNumfile_b() {
            return numfile_b;
        }

        public void setNumfile_b(String numfile_b) {
            this.numfile_b = numfile_b;
        }

        public String getSwappages() {
            return swappages;
        }

        public void setSwappages(String swappages) {
            this.swappages = swappages;
        }

        public String getSwappages_b() {
            return swappages_b;
        }

        public void setSwappages_b(String swappages_b) {
            this.swappages_b = swappages_b;
        }

        public String getPhyspages() {
            return physpages;
        }

        public void setPhyspages(String physpages) {
            this.physpages = physpages;
        }

        public String getPhyspages_l() {
            return physpages_l;
        }

        public void setPhyspages_l(String physpages_l) {
            this.physpages_l = physpages_l;
        }
    }

    public static class VzQuotaBean {
        /**
         * occupied_kb : 4061836
         * softlimit_kb : 10485760
         * hardlimit_kb : 11010048
         * occupied_inodes : 70511
         * softlimit_inodes : 10240000
         * hardlimit_inodes : 10752000
         */

        private String occupied_kb;
        private String softlimit_kb;
        private String hardlimit_kb;
        private String occupied_inodes;
        private String softlimit_inodes;
        private String hardlimit_inodes;

        public String getOccupied_kb() {
            return occupied_kb;
        }

        public void setOccupied_kb(String occupied_kb) {
            this.occupied_kb = occupied_kb;
        }

        public String getSoftlimit_kb() {
            return softlimit_kb;
        }

        public void setSoftlimit_kb(String softlimit_kb) {
            this.softlimit_kb = softlimit_kb;
        }

        public String getHardlimit_kb() {
            return hardlimit_kb;
        }

        public void setHardlimit_kb(String hardlimit_kb) {
            this.hardlimit_kb = hardlimit_kb;
        }

        public String getOccupied_inodes() {
            return occupied_inodes;
        }

        public void setOccupied_inodes(String occupied_inodes) {
            this.occupied_inodes = occupied_inodes;
        }

        public String getSoftlimit_inodes() {
            return softlimit_inodes;
        }

        public void setSoftlimit_inodes(String softlimit_inodes) {
            this.softlimit_inodes = softlimit_inodes;
        }

        public String getHardlimit_inodes() {
            return hardlimit_inodes;
        }

        public void setHardlimit_inodes(String hardlimit_inodes) {
            this.hardlimit_inodes = hardlimit_inodes;
        }
    }
}
