package generatorSqlmapCustom.src.com.cmos.scrs.beans.satisfaction;

import java.util.Date;

public class SatisfactionReport {
    private String rowId;

    private Date starttime;

    private Date endtime;

    private String tennatId;

    private String agentId;

    private String agentName;

    private String agentCode;

    private Integer callType;

    private String orgName;

    private Integer callInNum;

    private Integer callOutNum;

    private Integer participateInNum;

    private Integer relativeStatisfactionNum;

    private Integer relativeNoStatisfactionNum;

    private Integer veryStatisfactionNum;

    private Integer statisfactionNum;

    private Integer generalStatisfactionNum;

    private Integer noStatisfactionNum;

    private Integer veryNoStatisfactionNum;

    private Date createTime;

    private String createDay;

    private Integer state;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId == null ? null : rowId.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getTennatId() {
        return tennatId;
    }

    public void setTennatId(String tennatId) {
        this.tennatId = tennatId == null ? null : tennatId.trim();
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode == null ? null : agentCode.trim();
    }

    public Integer getCallType() {
        return callType;
    }

    public void setCallType(Integer callType) {
        this.callType = callType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public Integer getCallInNum() {
        return callInNum;
    }

    public void setCallInNum(Integer callInNum) {
        this.callInNum = callInNum;
    }

    public Integer getCallOutNum() {
        return callOutNum;
    }

    public void setCallOutNum(Integer callOutNum) {
        this.callOutNum = callOutNum;
    }

    public Integer getParticipateInNum() {
        return participateInNum;
    }

    public void setParticipateInNum(Integer participateInNum) {
        this.participateInNum = participateInNum;
    }

    public Integer getRelativeStatisfactionNum() {
        return relativeStatisfactionNum;
    }

    public void setRelativeStatisfactionNum(Integer relativeStatisfactionNum) {
        this.relativeStatisfactionNum = relativeStatisfactionNum;
    }

    public Integer getRelativeNoStatisfactionNum() {
        return relativeNoStatisfactionNum;
    }

    public void setRelativeNoStatisfactionNum(Integer relativeNoStatisfactionNum) {
        this.relativeNoStatisfactionNum = relativeNoStatisfactionNum;
    }

    public Integer getVeryStatisfactionNum() {
        return veryStatisfactionNum;
    }

    public void setVeryStatisfactionNum(Integer veryStatisfactionNum) {
        this.veryStatisfactionNum = veryStatisfactionNum;
    }

    public Integer getStatisfactionNum() {
        return statisfactionNum;
    }

    public void setStatisfactionNum(Integer statisfactionNum) {
        this.statisfactionNum = statisfactionNum;
    }

    public Integer getGeneralStatisfactionNum() {
        return generalStatisfactionNum;
    }

    public void setGeneralStatisfactionNum(Integer generalStatisfactionNum) {
        this.generalStatisfactionNum = generalStatisfactionNum;
    }

    public Integer getNoStatisfactionNum() {
        return noStatisfactionNum;
    }

    public void setNoStatisfactionNum(Integer noStatisfactionNum) {
        this.noStatisfactionNum = noStatisfactionNum;
    }

    public Integer getVeryNoStatisfactionNum() {
        return veryNoStatisfactionNum;
    }

    public void setVeryNoStatisfactionNum(Integer veryNoStatisfactionNum) {
        this.veryNoStatisfactionNum = veryNoStatisfactionNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay == null ? null : createDay.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}