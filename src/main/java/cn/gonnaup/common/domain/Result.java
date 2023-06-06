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
     * 只表明请求成功
     *
     * @return
     */
    public static Result<String> ok() {
        return new Result<>("", Code.Success.code, Code.Success.description);
    }

    /**
     * 表明成功且带返回消息
     *
     * @param message 成功提示信息
     * @return
     */
    public static Result<String> okWithmessage(String message) {
        return new Result<>("", Code.Success.code, message);
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

    public static final class ResultBuilder<T> {
        private T data;
        private String code;
        private String message;

        private ResultBuilder() {
        }

        public static <T> ResultBuilder<T> aResult() {
            return new ResultBuilder<>();
        }

        public ResultBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }

        public ResultBuilder<T> withCode(String code) {
            this.code = code;
            return this;
        }

        public ResultBuilder<T> withMessage(String message) {
            this.message = message;
            return this;
        }

        public Result<T> build() {
            return new Result<>(data, code, message);
        }
    }
}
