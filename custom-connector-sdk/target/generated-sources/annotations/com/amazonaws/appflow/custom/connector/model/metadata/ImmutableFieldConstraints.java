package com.amazonaws.appflow.custom.connector.model.metadata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link FieldConstraints}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableFieldConstraints.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableFieldConstraints
    implements FieldConstraints {
  private final @Nullable RangeConstraint allowedLengthRange;
  private final @Nullable RangeConstraint allowedValueRange;
  private final @Nullable ImmutableList<String> allowedValues;
  private final @Nullable String allowedValuesRegexPattern;
  private final @Nullable String allowedDateFormat;

  private ImmutableFieldConstraints(
      @Nullable RangeConstraint allowedLengthRange,
      @Nullable RangeConstraint allowedValueRange,
      @Nullable ImmutableList<String> allowedValues,
      @Nullable String allowedValuesRegexPattern,
      @Nullable String allowedDateFormat) {
    this.allowedLengthRange = allowedLengthRange;
    this.allowedValueRange = allowedValueRange;
    this.allowedValues = allowedValues;
    this.allowedValuesRegexPattern = allowedValuesRegexPattern;
    this.allowedDateFormat = allowedDateFormat;
  }

  /**
   * Min and Max range of the length of the value.
   */
  @JsonProperty("allowedLengthRange")
  @Override
  public @Nullable RangeConstraint allowedLengthRange() {
    return allowedLengthRange;
  }

  /**
   * Min and Max range of value of this field.
   */
  @JsonProperty("allowedValueRange")
  @Override
  public @Nullable RangeConstraint allowedValueRange() {
    return allowedValueRange;
  }

  /**
   * List of allowed values for this field.
   */
  @JsonProperty("allowedValues")
  @Override
  public @Nullable ImmutableList<String> allowedValues() {
    return allowedValues;
  }

  /**
   * Value of the field should match with this regex pattern.
   */
  @JsonProperty("allowedValuesRegexPattern")
  @Override
  public @Nullable String allowedValuesRegexPattern() {
    return allowedValuesRegexPattern;
  }

  /**
   * Allowed data format for the field.
   */
  @JsonProperty("allowedDateFormat")
  @Override
  public @Nullable String allowedDateFormat() {
    return allowedDateFormat;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldConstraints#allowedLengthRange() allowedLengthRange} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param allowedLengthRange A new value for allowedLengthRange (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldConstraints withAllowedLengthRange(@Nullable RangeConstraint allowedLengthRange) {
    if (this.allowedLengthRange == allowedLengthRange) return this;
    return new ImmutableFieldConstraints(
        allowedLengthRange,
        this.allowedValueRange,
        this.allowedValues,
        this.allowedValuesRegexPattern,
        this.allowedDateFormat);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldConstraints#allowedValueRange() allowedValueRange} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param allowedValueRange A new value for allowedValueRange (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldConstraints withAllowedValueRange(@Nullable RangeConstraint allowedValueRange) {
    if (this.allowedValueRange == allowedValueRange) return this;
    return new ImmutableFieldConstraints(
        this.allowedLengthRange,
        allowedValueRange,
        this.allowedValues,
        this.allowedValuesRegexPattern,
        this.allowedDateFormat);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FieldConstraints#allowedValues() allowedValues}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFieldConstraints withAllowedValues(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableFieldConstraints(
          this.allowedLengthRange,
          this.allowedValueRange,
          null,
          this.allowedValuesRegexPattern,
          this.allowedDateFormat);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableFieldConstraints(
        this.allowedLengthRange,
        this.allowedValueRange,
        newValue,
        this.allowedValuesRegexPattern,
        this.allowedDateFormat);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link FieldConstraints#allowedValues() allowedValues}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of allowedValues elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableFieldConstraints withAllowedValues(@Nullable Iterable<String> elements) {
    if (this.allowedValues == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableFieldConstraints(
        this.allowedLengthRange,
        this.allowedValueRange,
        newValue,
        this.allowedValuesRegexPattern,
        this.allowedDateFormat);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldConstraints#allowedValuesRegexPattern() allowedValuesRegexPattern} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param allowedValuesRegexPattern A new value for allowedValuesRegexPattern (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldConstraints withAllowedValuesRegexPattern(@Nullable String allowedValuesRegexPattern) {
    if (Objects.equal(this.allowedValuesRegexPattern, allowedValuesRegexPattern)) return this;
    return new ImmutableFieldConstraints(
        this.allowedLengthRange,
        this.allowedValueRange,
        this.allowedValues,
        allowedValuesRegexPattern,
        this.allowedDateFormat);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link FieldConstraints#allowedDateFormat() allowedDateFormat} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param allowedDateFormat A new value for allowedDateFormat (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableFieldConstraints withAllowedDateFormat(@Nullable String allowedDateFormat) {
    if (Objects.equal(this.allowedDateFormat, allowedDateFormat)) return this;
    return new ImmutableFieldConstraints(
        this.allowedLengthRange,
        this.allowedValueRange,
        this.allowedValues,
        this.allowedValuesRegexPattern,
        allowedDateFormat);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableFieldConstraints} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableFieldConstraints
        && equalTo((ImmutableFieldConstraints) another);
  }

  private boolean equalTo(ImmutableFieldConstraints another) {
    return Objects.equal(allowedLengthRange, another.allowedLengthRange)
        && Objects.equal(allowedValueRange, another.allowedValueRange)
        && Objects.equal(allowedValues, another.allowedValues)
        && Objects.equal(allowedValuesRegexPattern, another.allowedValuesRegexPattern)
        && Objects.equal(allowedDateFormat, another.allowedDateFormat);
  }

  /**
   * Computes a hash code from attributes: {@code allowedLengthRange}, {@code allowedValueRange}, {@code allowedValues}, {@code allowedValuesRegexPattern}, {@code allowedDateFormat}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(allowedLengthRange);
    h = h * 17 + Objects.hashCode(allowedValueRange);
    h = h * 17 + Objects.hashCode(allowedValues);
    h = h * 17 + Objects.hashCode(allowedValuesRegexPattern);
    h = h * 17 + Objects.hashCode(allowedDateFormat);
    return h;
  }

  /**
   * Prints the immutable value {@code FieldConstraints} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("FieldConstraints")
        .omitNullValues()
        .add("allowedLengthRange", allowedLengthRange)
        .add("allowedValueRange", allowedValueRange)
        .add("allowedValues", allowedValues)
        .add("allowedValuesRegexPattern", allowedValuesRegexPattern)
        .add("allowedDateFormat", allowedDateFormat)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements FieldConstraints {
    @Nullable RangeConstraint allowedLengthRange;
    @Nullable RangeConstraint allowedValueRange;
    List<String> allowedValues = null;
    @Nullable String allowedValuesRegexPattern;
    @Nullable String allowedDateFormat;
    @JsonProperty("allowedLengthRange")
    public void setAllowedLengthRange(@Nullable RangeConstraint allowedLengthRange) {
      this.allowedLengthRange = allowedLengthRange;
    }
    @JsonProperty("allowedValueRange")
    public void setAllowedValueRange(@Nullable RangeConstraint allowedValueRange) {
      this.allowedValueRange = allowedValueRange;
    }
    @JsonProperty("allowedValues")
    public void setAllowedValues(@Nullable List<String> allowedValues) {
      this.allowedValues = allowedValues;
    }
    @JsonProperty("allowedValuesRegexPattern")
    public void setAllowedValuesRegexPattern(@Nullable String allowedValuesRegexPattern) {
      this.allowedValuesRegexPattern = allowedValuesRegexPattern;
    }
    @JsonProperty("allowedDateFormat")
    public void setAllowedDateFormat(@Nullable String allowedDateFormat) {
      this.allowedDateFormat = allowedDateFormat;
    }
    @Override
    public RangeConstraint allowedLengthRange() { throw new UnsupportedOperationException(); }
    @Override
    public RangeConstraint allowedValueRange() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> allowedValues() { throw new UnsupportedOperationException(); }
    @Override
    public String allowedValuesRegexPattern() { throw new UnsupportedOperationException(); }
    @Override
    public String allowedDateFormat() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableFieldConstraints fromJson(Json json) {
    ImmutableFieldConstraints.Builder builder = ImmutableFieldConstraints.builder();
    if (json.allowedLengthRange != null) {
      builder.allowedLengthRange(json.allowedLengthRange);
    }
    if (json.allowedValueRange != null) {
      builder.allowedValueRange(json.allowedValueRange);
    }
    if (json.allowedValues != null) {
      builder.addAllAllowedValues(json.allowedValues);
    }
    if (json.allowedValuesRegexPattern != null) {
      builder.allowedValuesRegexPattern(json.allowedValuesRegexPattern);
    }
    if (json.allowedDateFormat != null) {
      builder.allowedDateFormat(json.allowedDateFormat);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link FieldConstraints} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable FieldConstraints instance
   */
  public static ImmutableFieldConstraints copyOf(FieldConstraints instance) {
    if (instance instanceof ImmutableFieldConstraints) {
      return (ImmutableFieldConstraints) instance;
    }
    return ImmutableFieldConstraints.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableFieldConstraints ImmutableFieldConstraints}.
   * @return A new ImmutableFieldConstraints builder
   */
  public static ImmutableFieldConstraints.Builder builder() {
    return new ImmutableFieldConstraints.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableFieldConstraints ImmutableFieldConstraints}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable RangeConstraint allowedLengthRange;
    private @Nullable RangeConstraint allowedValueRange;
    private ImmutableList.Builder<String> allowedValues = null;
    private @Nullable String allowedValuesRegexPattern;
    private @Nullable String allowedDateFormat;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code FieldConstraints} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(FieldConstraints instance) {
      Preconditions.checkNotNull(instance, "instance");
      @Nullable RangeConstraint allowedLengthRangeValue = instance.allowedLengthRange();
      if (allowedLengthRangeValue != null) {
        allowedLengthRange(allowedLengthRangeValue);
      }
      @Nullable RangeConstraint allowedValueRangeValue = instance.allowedValueRange();
      if (allowedValueRangeValue != null) {
        allowedValueRange(allowedValueRangeValue);
      }
      @Nullable List<String> allowedValuesValue = instance.allowedValues();
      if (allowedValuesValue != null) {
        addAllAllowedValues(allowedValuesValue);
      }
      @Nullable String allowedValuesRegexPatternValue = instance.allowedValuesRegexPattern();
      if (allowedValuesRegexPatternValue != null) {
        allowedValuesRegexPattern(allowedValuesRegexPatternValue);
      }
      @Nullable String allowedDateFormatValue = instance.allowedDateFormat();
      if (allowedDateFormatValue != null) {
        allowedDateFormat(allowedDateFormatValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link FieldConstraints#allowedLengthRange() allowedLengthRange} attribute.
     * @param allowedLengthRange The value for allowedLengthRange (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder allowedLengthRange(@Nullable RangeConstraint allowedLengthRange) {
      this.allowedLengthRange = allowedLengthRange;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldConstraints#allowedValueRange() allowedValueRange} attribute.
     * @param allowedValueRange The value for allowedValueRange (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder allowedValueRange(@Nullable RangeConstraint allowedValueRange) {
      this.allowedValueRange = allowedValueRange;
      return this;
    }

    /**
     * Adds one element to {@link FieldConstraints#allowedValues() allowedValues} list.
     * @param element A allowedValues element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllowedValues(String element) {
      if (this.allowedValues == null) {
        this.allowedValues = ImmutableList.builder();
      }
      this.allowedValues.add(element);
      return this;
    }

    /**
     * Adds elements to {@link FieldConstraints#allowedValues() allowedValues} list.
     * @param elements An array of allowedValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllowedValues(String... elements) {
      if (this.allowedValues == null) {
        this.allowedValues = ImmutableList.builder();
      }
      this.allowedValues.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link FieldConstraints#allowedValues() allowedValues} list.
     * @param elements An iterable of allowedValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder allowedValues(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.allowedValues = null;
        return this;
      }
      this.allowedValues = ImmutableList.builder();
      return addAllAllowedValues(elements);
    }

    /**
     * Adds elements to {@link FieldConstraints#allowedValues() allowedValues} list.
     * @param elements An iterable of allowedValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllAllowedValues(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "allowedValues element");
      if (this.allowedValues == null) {
        this.allowedValues = ImmutableList.builder();
      }
      this.allowedValues.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link FieldConstraints#allowedValuesRegexPattern() allowedValuesRegexPattern} attribute.
     * @param allowedValuesRegexPattern The value for allowedValuesRegexPattern (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder allowedValuesRegexPattern(@Nullable String allowedValuesRegexPattern) {
      this.allowedValuesRegexPattern = allowedValuesRegexPattern;
      return this;
    }

    /**
     * Initializes the value for the {@link FieldConstraints#allowedDateFormat() allowedDateFormat} attribute.
     * @param allowedDateFormat The value for allowedDateFormat (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder allowedDateFormat(@Nullable String allowedDateFormat) {
      this.allowedDateFormat = allowedDateFormat;
      return this;
    }

    /**
     * Builds a new {@link ImmutableFieldConstraints ImmutableFieldConstraints}.
     * @return An immutable instance of FieldConstraints
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableFieldConstraints build() {
      return new ImmutableFieldConstraints(
          allowedLengthRange,
          allowedValueRange,
          allowedValues == null ? null : allowedValues.build(),
          allowedValuesRegexPattern,
          allowedDateFormat);
    }
  }
}
