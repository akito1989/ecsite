package example.app.entity;

public class MstProduct {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_product.code
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    private Integer code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_product.name
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_product.price
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    private Integer price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mst_product.gazou
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    private byte[] gazou;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_product.code
     *
     * @return the value of mst_product.code
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public Integer getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_product.code
     *
     * @param code the value for mst_product.code
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_product.name
     *
     * @return the value of mst_product.name
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_product.name
     *
     * @param name the value for mst_product.name
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_product.price
     *
     * @return the value of mst_product.price
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_product.price
     *
     * @param price the value for mst_product.price
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mst_product.gazou
     *
     * @return the value of mst_product.gazou
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public byte[] getGazou() {
        return gazou;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mst_product.gazou
     *
     * @param gazou the value for mst_product.gazou
     *
     * @mbggenerated Sun Mar 25 02:24:53 AEDT 2018
     */
    public void setGazou(byte[] gazou) {
        this.gazou = gazou;
    }
}