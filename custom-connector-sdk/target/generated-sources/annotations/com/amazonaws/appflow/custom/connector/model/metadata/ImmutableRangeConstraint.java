package com.amazonaws.appflow.custom.connector.model.metadata;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link RangeConstraint}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRangeConstraint.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableRangeConstraint
    implements RangeConstraint {
  private final BigDecimal minRange;
  private final BigDecimal maxRange;

  private ImmutableRangeConstraint(BigDecimal minRange, BigDecimal maxRange) {
    this.minRange = minRange;
    this.maxRange = maxRange;
  }

  /**
   * Minimum value of the range.
   */
  @JsonProperty("minRange")
  @Override
  public BigDecimal minRange() {
    return minRange;
  }

  /**
   * Maximum value of the range.
   */
  @JsonProperty("maxRange")
  @Override
  public BigDecimal maxRange() {
    return maxRange;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RangeConstraint#minRange() minRange} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param minRange A new value for minRange
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRangeConstraint withMinRange(BigDecimal minRange) {
    if (this.minRange == minRange) return this;
    BigDecimal newValue = Preconditions.checkNotNull(minRange, "minRange");
    return new ImmutableRangeConstraint(newValue, this.maxRange);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RangeConstraint#maxRange() maxRange} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param maxRange A new value for maxRange
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRangeConstraint withMaxRange(BigDecimal maxRange) {
    if (this.maxRange == maxRange) return this;
    BigDecimal newValue = Preconditions.checkNotNull(maxRange, "maxRange");
    return new ImmutableRangeConstraint(this.minRange, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRangeConstraint} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRangeConstraint
        && equalTo((ImmutableRangeConstraint) another);
  }

  private boolean equalTo(ImmutableRangeConstraint another) {
    return minRange.equals(another.minRange)
        && maxRange.equals(another.maxRange);
  }

  /**
   * Computes a hash code from attributes: {@code minRange}, {@code maxRange}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + minRange.hashCode();
    h = h * 17 + maxRange.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code RangeConstraint} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("RangeConstraint")
        .omitNullValues()
        .add("minRange", minRange)
        .add("maxRange", maxRange)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements RangeConstraint {
    @Nullable BigDecimal minRange;
    @Nullable BigDecimal maxRange;
    @JsonProperty("minRange")
    public void setMinRange(BigDecimal minRange) {
      this.minRange = minRange;
    }
    @JsonProperty("maxRange")
    public void setMaxRange(BigDecimal maxRange) {
      this.maxRange = maxRange;
    }
    @Override
    public BigDecimal minRange() { throw new UnsupportedOperationException(); }
    @Override
    public BigDecimal maxRange() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableRangeConstraint fromJson(Json json) {
    ImmutableRangeConstraint.Builder builder = ImmutableRangeConstraint.builder();
    if (json.minRange != null) {
      builder.minRange(json.minRange);
    }
    if (json.maxRange != null) {
      builder.maxRange(json.maxRange);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link RangeConstraint} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RangeConstraint instance
   */
  public static ImmutableRangeConstraint copyOf(RangeConstraint instance) {
    if (instance instanceof ImmutableRangeConstraint) {
      return (ImmutableRangeConstraint) instance;
    }
    return ImmutableRangeConstraint.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRangeConstraint ImmutableRangeConstraint}.
   * @return A new ImmutableRangeConstraint builder
   */
  public static ImmutableRangeConstraint.Builder builder() {
    return new ImmutableRangeConstraint.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRangeConstraint ImmutableRangeConstraint}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_MIN_RANGE = 0x1L;
    private static final long INIT_BIT_MAX_RANGE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable BigDecimal minRange;
    private @Nullable BigDecimal maxRange;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RangeConstraint} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(RangeConstraint instance) {
      Preconditions.checkNotNull(instance, "instance");
      minRange(instance.minRange());
      maxRange(instance.maxRange());
      return this;
    }

    /**
     * Initializes the value for the {@link RangeConstraint#minRange() minRange} attribute.
     * @param minRange The value for minRange 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder minRange(BigDecimal minRange) {
      this.minRange = Preconditions.checkNotNull(minRange, "minRange");
      initBits &= ~INIT_BIT_MIN_RANGE;
      return this;
    }

    /**
     * Initializes the value for the {@link RangeConstraint#maxRange() maxRange} attribute.
     * @param maxRange The value for maxRange 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder maxRange(BigDecimal maxRange) {
      this.maxRange = Preconditions.checkNotNull(maxRange, "maxRange");
      initBits &= ~INIT_BIT_MAX_RANGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableRangeConstraint ImmutableRangeConstraint}.
     * @return An immutable instance of RangeConstraint
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRangeConstraint build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRangeConstraint(minRange, maxRange);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_MIN_RANGE) != 0) attributes.add("minRange");
      if ((initBits & INIT_BIT_MAX_RANGE) != 0) attributes.add("maxRange");
      return "Cannot build RangeConstraint, some of required attributes are not set " + attributes;
    }
  }
}
