package pri.liyang.entity;

/**
 * 数据库表的字段信息
 */
public class FieldInfo {

    //数据库名
    private String dbName;

    //表名
    private String tableName;

    //列名
    private String columnName;

    //默认值
    private String columnDefault;

    //是否可为空
    private String isNullAble;

    //数据类型
    private String dataType;

    //字符最大长度
    private String characterMaximumLength;

    //八进制字符长度
    private String characterOctetLength;

    //数字精度
    private String numericPrecision;

    //保留小数位数
    private String NumericScale;

    //字符集名字
    private String characterSetName;

    //校准字符集名字
    private String collationName;

    //列类型
    private String columnType;

    //键信息
    private String columnKey;

    //扩展信息
    private String extra;

    //操作权限
    private String privileges;

    //列注释
    private String columnComment;


    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getIsNullAble() {
        return isNullAble;
    }

    public void setIsNullAble(String isNullAble) {
        this.isNullAble = isNullAble;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(String characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public String getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(String characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    public String getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(String numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public String getNumericScale() {
        return NumericScale;
    }

    public void setNumericScale(String numericScale) {
        NumericScale = numericScale;
    }

    public String getCharacterSetName() {
        return characterSetName;
    }

    public void setCharacterSetName(String characterSetName) {
        this.characterSetName = characterSetName;
    }

    public String getCollationName() {
        return collationName;
    }

    public void setCollationName(String collationName) {
        this.collationName = collationName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }


    @Override
    public String toString() {
        return "FieldInfo{" +
                "dbName='" + dbName + '\'' +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnDefault='" + columnDefault + '\'' +
                ", isNullAble='" + isNullAble + '\'' +
                ", dataType='" + dataType + '\'' +
                ", characterMaximumLength='" + characterMaximumLength + '\'' +
                ", characterOctetLength='" + characterOctetLength + '\'' +
                ", numericPrecision='" + numericPrecision + '\'' +
                ", NumericScale='" + NumericScale + '\'' +
                ", characterSetName='" + characterSetName + '\'' +
                ", collationName='" + collationName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", columnKey='" + columnKey + '\'' +
                ", extra='" + extra + '\'' +
                ", privileges='" + privileges + '\'' +
                ", columnComment='" + columnComment + '\'' +
                '}';
    }

}
