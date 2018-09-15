package com.enfernuz.quik.lua.rpc.api.structures;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class Security {

    private static final String CODE_FIELD = "code";
    private static final String NAME_FIELD = "name";
    private static final String SHORT_NAME_FIELD = "short_name";
    private static final String CLASS_CODE_FIELD = "class_code_field";
    private static final String CLASS_NAME_FIELD = "class_name_field";
    private static final String FACE_VALUE_FIELD = "face_value";
    private static final String FACE_UNIT_FIELD = "face_unit";
    private static final String SCALE_FIELD = "scale";
    private static final String MAT_DATE_FIELD = "mat_date";
    private static final String LOT_SIZE_FIELD = "lot_size";
    private static final String ISIN_CODE_FIELD = "isin_code";
    private static final String MIN_PRICE_STEP_FIELD = "min_price_step";

    String code;
    String name;
    String shortName;
    String classCode;
    String className;
    String faceValue;
    String faceUnit;
    String scale;
    String matDate;
    String lotSize;
    String isinCode;
    String minPriceStep;

    private transient @NonFinal @Getter(AccessLevel.NONE) int hashCode;
    private transient @NonFinal @Getter(AccessLevel.NONE) String asString;

    @Builder
    @JsonCreator
    private Security(
            @JsonProperty(CODE_FIELD) final String code,
            @JsonProperty(NAME_FIELD) final String name,
            @JsonProperty(SHORT_NAME_FIELD) final String shortName,
            @JsonProperty(CLASS_CODE_FIELD) final String classCode,
            @JsonProperty(CLASS_NAME_FIELD) final String className,
            @JsonProperty(FACE_VALUE_FIELD) final String faceValue,
            @JsonProperty(FACE_UNIT_FIELD) final String faceUnit,
            @JsonProperty(SCALE_FIELD) final String scale,
            @JsonProperty(MAT_DATE_FIELD) final String matDate,
            @JsonProperty(LOT_SIZE_FIELD) final String lotSize,
            @JsonProperty(ISIN_CODE_FIELD) final String isinCode,
            @JsonProperty(MIN_PRICE_STEP_FIELD) final String minPriceStep) {

        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.classCode = classCode;
        this.className = className;
        this.faceValue = faceValue;
        this.faceUnit = faceUnit;
        this.scale = scale;
        this.matDate = matDate;
        this.lotSize = lotSize;
        this.isinCode = isinCode;
        this.minPriceStep = minPriceStep;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof Security) ) {
            return false;
        } else {
            final Security security = (Security) o;
            return Objects.equals(code, security.code) &&
                    Objects.equals(name, security.name) &&
                    Objects.equals(shortName, security.shortName) &&
                    Objects.equals(classCode, security.classCode) &&
                    Objects.equals(className, security.className) &&
                    Objects.equals(faceValue, security.faceValue) &&
                    Objects.equals(faceUnit, security.faceUnit) &&
                    Objects.equals(scale, security.scale) &&
                    Objects.equals(matDate, security.matDate) &&
                    Objects.equals(lotSize, security.lotSize) &&
                    Objects.equals(isinCode, security.isinCode) &&
                    Objects.equals(minPriceStep, security.minPriceStep);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode = Objects.hash(
                    code,
                    name,
                    shortName,
                    classCode,
                    className,
                    faceValue,
                    faceUnit,
                    scale,
                    matDate,
                    lotSize,
                    isinCode,
                    minPriceStep
            );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add(CODE_FIELD, code)
                    .add(NAME_FIELD, name)
                    .add(SHORT_NAME_FIELD, shortName)
                    .add(CLASS_CODE_FIELD, classCode)
                    .add(CLASS_NAME_FIELD, className)
                    .add(FACE_VALUE_FIELD, faceValue)
                    .add(FACE_UNIT_FIELD, faceUnit)
                    .add(SCALE_FIELD, scale)
                    .add(MAT_DATE_FIELD, matDate)
                    .add(LOT_SIZE_FIELD, lotSize)
                    .add(ISIN_CODE_FIELD, isinCode)
                    .add(MIN_PRICE_STEP_FIELD, minPriceStep)
                    .toString();
        }

        return asString;
    }
}
