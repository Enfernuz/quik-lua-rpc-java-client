package com.enfernuz.quik.lua.rpc.api.security.zmq;

import com.google.common.base.Strings;
import zmq.util.Z85;

import java.util.Arrays;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Ключ защитного механизма CURVE.
 *
 * @see <a href="http://curvezmq.org/page:read-the-docs">Документация механизма CURVE</a>
 * @see <a href="https://rfc.zeromq.org/spec:26/CURVEZMQ">Спецификация механизма CURVE</a>
 */
public class CurveKey {

    private final String z85Form;
    private final byte[] binaryForm;

    /**
     * Создаёт экземпляр CURVE-ключа на основе Z85-представления.
     *
     * @param z85String  Z85-представление CURVE-ключа
     * @return экземпляр CURVE-ключа, соответствующий переданному Z85-представлению
     * @throws IllegalArgumentException если указанное Z85-представление является null, пустой строкой или строкой
     * длины, отличной от 40 символов
     */
    public static CurveKey fromString(final String z85String) {

        checkArgument(
                !Strings.isNullOrEmpty(z85String),
                "The argument \"z85String\" must not be null or an empty string."
        );

        checkArgument(
                z85String.length() == 40,
                "The argument \"z85String\" must be a 40-characters length Z85-encoded string."
        );

        return new CurveKey(z85String, Z85.decode(z85String));
    }

    /**
     * Создаёт экземпляр CURVE-ключа на основе бинарного представления.
     *
     * @param binaryForm  бинарное представление CURVE-ключа
     * @return экземпляр CURVE-ключа, соответствующий переданному бинарному представлению
     * @throws NullPointerException если указанное бинарное представление является null
     */
    public static CurveKey fromBinary(final byte[] binaryForm) {

        final byte[] copyBinaryForm = binaryForm.clone();

        return new CurveKey(Z85.encode(copyBinaryForm, copyBinaryForm.length), copyBinaryForm);
    }

    private CurveKey(final String z85Form, final byte[] binaryForm) {

        this.z85Form = z85Form;
        this.binaryForm = binaryForm;
    }

    /**
     * Получает Z85-представление данного CURVE-ключа.
     *
     * @return Z85-представление данного CURVE-ключа
     * @see <a href="https://rfc.zeromq.org/spec:32/Z85">Спецификация формата Z85</a>
     */
    public String asZ85String() {
        return z85Form;
    }

    /**
     * Получает бинарное представление данного CURVE-ключа.
     *
     * @return бинарное представление данного CURVE-ключа
     */
    public byte[] asBinary() {
        return binaryForm.clone();
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof CurveKey) ) {
            return false;
        } else {
            final CurveKey other = (CurveKey) o;
            return Arrays.equals(binaryForm, other.binaryForm) && Objects.equals(z85Form, other.z85Form);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(z85Form, binaryForm);
    }

    /**
     * @return Z85-представление данного CURVE-ключа
     */
    @Override
    public String toString() {
        return z85Form;
    }
}
