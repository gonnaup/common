package cn.gonnaup.common.domain;

/**
 * 公共返回模型
 *
 * @author gonnaup
 * @version created at 2023/5/31 下午5:45
 */
public record Result<T>(T data, String code, String message) {

    /**
     * 请求成功时返回结果
     *
     * @param data 返回数据
     * @param <T>
     * @return 成功结果模型
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(data, Code.Success.code, Code.Success.description);
    }

    /**
     * 请求失败时返回结果
     *
     * @param reason 失败原因
     * @return 失败结果模型
     */
    public static Result<String> fail(String reason) {
        return new Result<>("", Code.Fail.code, reason);
    }

    /**
     * 返回码，待完善
     */
    enum Code {

        Success("0", "ok"),
        Fail("400", "fail");

        private final String code;

        private final String description;

        Code(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public String code() {
            return code;
        }

        public String description() {
            return description;
        }
    }
}
