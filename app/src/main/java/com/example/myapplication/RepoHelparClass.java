package com.example.myapplication;

public class RepoHelparClass {
    String donarname, donarphone, donaremail, donarpassword;

    public RepoHelparClass() {

    }

    public RepoHelparClass(String donarname, String donarphone, String donaremail, String donarpassword) {
        this.donarname = donarname;
        this.donarphone = donarphone;
        this.donaremail = donaremail;
        this.donarpassword = donarpassword;
    }

    public String getDonarname() {
        return donarname;
    }

    public void setDonarname(String donarname) {
        this.donarname = donarname;
    }

    public String getDonarphone() {
        return donarphone;
    }

    public void setDonarphone(String donarphone) {
        this.donarphone = donarphone;
    }

    public String getDonaremail() {
        return donaremail;
    }

    public void setDonaremail(String donaremail) {
        this.donaremail = donaremail;
    }

    public String getDonarpassword() {
        return donarpassword;
    }

    public void setDonarpassword(String donarpassword) {
        this.donarpassword = donarpassword;
    }
}
