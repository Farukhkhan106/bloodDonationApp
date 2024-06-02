package com.example.myapplication;

import android.widget.EditText;

public class DonarHelperClass {
      String donarname, donarphone, donaremail, donarpassword;

        public DonarHelperClass() {

        }

        public DonarHelperClass(String donarname, String donarphone, String donaremail, String donarpassword) {
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

