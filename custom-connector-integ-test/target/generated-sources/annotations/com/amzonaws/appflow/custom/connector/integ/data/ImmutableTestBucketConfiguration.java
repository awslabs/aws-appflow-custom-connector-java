package com.amzonaws.appflow.custom.connector.integ.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link TestBucketConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTestBucketConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableTestBucketConfiguration
    implements TestBucketConfiguration {
  private final String bucketName;
  private final String bucketPrefix;

  private ImmutableTestBucketConfiguration(String bucketName, String bucketPrefix) {
    this.bucketName = bucketName;
    this.bucketPrefix = bucketPrefix;
  }

  /**
   * @return The value of the {@code bucketName} attribute
   */
  @JsonProperty("bucketName")
  @Override
  public String bucketName() {
    return bucketName;
  }

  /**
   * @return The value of the {@code bucketPrefix} attribute
   */
  @JsonProperty("bucketPrefix")
  @Override
  public String bucketPrefix() {
    return bucketPrefix;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TestBucketConfiguration#bucketName() bucketName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param bucketName A new value for bucketName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTestBucketConfiguration withBucketName(String bucketName) {
    if (this.bucketName.equals(bucketName)) return this;
    String newValue = Preconditions.checkNotNull(bucketName, "bucketName");
    return new ImmutableTestBucketConfiguration(newValue, this.bucketPrefix);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TestBucketConfiguration#bucketPrefix() bucketPrefix} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param bucketPrefix A new value for bucketPrefix
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTestBucketConfiguration withBucketPrefix(String bucketPrefix) {
    if (this.bucketPrefix.equals(bucketPrefix)) return this;
    String newValue = Preconditions.checkNotNull(bucketPrefix, "bucketPrefix");
    return new ImmutableTestBucketConfiguration(this.bucketName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTestBucketConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTestBucketConfiguration
        && equalTo((ImmutableTestBucketConfiguration) another);
  }

  private boolean equalTo(ImmutableTestBucketConfiguration another) {
    return bucketName.equals(another.bucketName)
        && bucketPrefix.equals(another.bucketPrefix);
  }

  /**
   * Computes a hash code from attributes: {@code bucketName}, {@code bucketPrefix}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + bucketName.hashCode();
    h = h * 17 + bucketPrefix.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code TestBucketConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("TestBucketConfiguration")
        .omitNullValues()
        .add("bucketName", bucketName)
        .add("bucketPrefix", bucketPrefix)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements TestBucketConfiguration {
    @Nullable String bucketName;
    @Nullable String bucketPrefix;
    @JsonProperty("bucketName")
    public void setBucketName(String bucketName) {
      this.bucketName = bucketName;
    }
    @JsonProperty("bucketPrefix")
    public void setBucketPrefix(String bucketPrefix) {
      this.bucketPrefix = bucketPrefix;
    }
    @Override
    public String bucketName() { throw new UnsupportedOperationException(); }
    @Override
    public String bucketPrefix() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableTestBucketConfiguration fromJson(Json json) {
    ImmutableTestBucketConfiguration.Builder builder = ImmutableTestBucketConfiguration.builder();
    if (json.bucketName != null) {
      builder.bucketName(json.bucketName);
    }
    if (json.bucketPrefix != null) {
      builder.bucketPrefix(json.bucketPrefix);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link TestBucketConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable TestBucketConfiguration instance
   */
  public static ImmutableTestBucketConfiguration copyOf(TestBucketConfiguration instance) {
    if (instance instanceof ImmutableTestBucketConfiguration) {
      return (ImmutableTestBucketConfiguration) instance;
    }
    return ImmutableTestBucketConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTestBucketConfiguration ImmutableTestBucketConfiguration}.
   * @return A new ImmutableTestBucketConfiguration builder
   */
  public static ImmutableTestBucketConfiguration.Builder builder() {
    return new ImmutableTestBucketConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTestBucketConfiguration ImmutableTestBucketConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_BUCKET_NAME = 0x1L;
    private static final long INIT_BIT_BUCKET_PREFIX = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String bucketName;
    private @Nullable String bucketPrefix;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code TestBucketConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(TestBucketConfiguration instance) {
      Preconditions.checkNotNull(instance, "instance");
      bucketName(instance.bucketName());
      bucketPrefix(instance.bucketPrefix());
      return this;
    }

    /**
     * Initializes the value for the {@link TestBucketConfiguration#bucketName() bucketName} attribute.
     * @param bucketName The value for bucketName 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder bucketName(String bucketName) {
      this.bucketName = Preconditions.checkNotNull(bucketName, "bucketName");
      initBits &= ~INIT_BIT_BUCKET_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link TestBucketConfiguration#bucketPrefix() bucketPrefix} attribute.
     * @param bucketPrefix The value for bucketPrefix 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder bucketPrefix(String bucketPrefix) {
      this.bucketPrefix = Preconditions.checkNotNull(bucketPrefix, "bucketPrefix");
      initBits &= ~INIT_BIT_BUCKET_PREFIX;
      return this;
    }

    /**
     * Builds a new {@link ImmutableTestBucketConfiguration ImmutableTestBucketConfiguration}.
     * @return An immutable instance of TestBucketConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTestBucketConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableTestBucketConfiguration(bucketName, bucketPrefix);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_BUCKET_NAME) != 0) attributes.add("bucketName");
      if ((initBits & INIT_BIT_BUCKET_PREFIX) != 0) attributes.add("bucketPrefix");
      return "Cannot build TestBucketConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
