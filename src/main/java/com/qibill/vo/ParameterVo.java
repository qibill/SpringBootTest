package com.qibill.vo;


import com.qibill.format.MyDateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 *
 * @author qibill
 * @date 2018/12/18 10:58
 **/
public class ParameterVo {

    @NotBlank(message = "母亲姓名不能为空")
    private String mothername;

//    @NotNull(message = "婴儿生日不能为空")
    @MyDateTimeFormat (pattern = "yyyy-MM-dd", message = "婴儿生日格式不对")
//    @Past(message = "婴儿生日必须是过去的日期")
    private Date birthday;

//    @NotNull(message = "采血日期不能为空")
    @DateTimeFormat (pattern = "yyyy-MM-dd HH:mm")
//    @Past(message = "采血日期必须是过去的日期")
    private Date collectdate;

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public Date getCollectdate() {
        return collectdate;
    }

    public void setCollectdate(Date collectdate) {
        this.collectdate = collectdate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "ParameterVo{" +
                "mothername='" + mothername + '\'' +
                ", birthday=" + birthday +
                ", collectdate=" + collectdate +
                '}';
    }
}
