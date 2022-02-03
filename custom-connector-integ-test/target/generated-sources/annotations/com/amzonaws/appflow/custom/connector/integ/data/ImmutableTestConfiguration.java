package com.amzonaws.appflow.custom.connector.integ.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link TestConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTestConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableTestConfiguration
    implements TestConfiguration {
  private final @Nullable String resourcePrefix;
  private final ImmutableList<CustomConnectorConfiguration> customConnectorConfigurations;
  private final ImmutableList<CustomConnectorProfileConfiguration> customConnectorProfileConfigurations;
  private final ImmutableList<OnDemandToS3TestConfiguration> onDemandToS3TestConfigurations;
  private final ImmutableList<OnDemandFromS3TestConfiguration> onDemandFromS3TestConfigurations;
  private final ImmutableList<ListConnectorEntitiesTestConfiguration> listConnectorEntitiesTestConfigurations;
  private final ImmutableList<DescribeConnectorEntityTestConfiguration> describeConnectorEntityTestConfigurations;
  private final TestBucketConfiguration testBucketConfiguration;

  private ImmutableTestConfiguration(
      @Nullable String resourcePrefix,
      ImmutableList<CustomConnectorConfiguration> customConnectorConfigurations,
      ImmutableList<CustomConnectorProfileConfiguration> customConnectorProfileConfigurations,
      ImmutableList<OnDemandToS3TestConfiguration> onDemandToS3TestConfigurations,
      ImmutableList<OnDemandFromS3TestConfiguration> onDemandFromS3TestConfigurations,
      ImmutableList<ListConnectorEntitiesTestConfiguration> listConnectorEntitiesTestConfigurations,
      ImmutableList<DescribeConnectorEntityTestConfiguration> describeConnectorEntityTestConfigurations,
      TestBucketConfiguration testBucketConfiguration) {
    this.resourcePrefix = resourcePrefix;
    this.customConnectorConfigurations = customConnectorConfigurations;
    this.customConnectorProfileConfigurations = customConnectorProfileConfigurations;
    this.onDemandToS3TestConfigurations = onDemandToS3TestConfigurations;
    this.onDemandFromS3TestConfigurations = onDemandFromS3TestConfigurations;
    this.listConnectorEntitiesTestConfigurations = listConnectorEntitiesTestConfigurations;
    this.describeConnectorEntityTestConfigurations = describeConnectorEntityTestConfigurations;
    this.testBucketConfiguration = testBucketConfiguration;
  }

  /**
   * @return The value of the {@code resourcePrefix} attribute
   */
  @JsonProperty("resourcePrefix")
  @Override
  public Optional<String> resourcePrefix() {
    return Optional.ofNullable(resourcePrefix);
  }

  /**
   * @return The value of the {@code customConnectorConfigurations} attribute
   */
  @JsonProperty("customConnectorConfigurations")
  @Override
  public ImmutableList<CustomConnectorConfiguration> customConnectorConfigurations() {
    return customConnectorConfigurations;
  }

  /**
   * @return The value of the {@code customConnectorProfileConfigurations} attribute
   */
  @JsonProperty("customConnectorProfileConfigurations")
  @Override
  public ImmutableList<CustomConnectorProfileConfiguration> customConnectorProfileConfigurations() {
    return customConnectorProfileConfigurations;
  }

  /**
   * @return The value of the {@code onDemandToS3TestConfigurations} attribute
   */
  @JsonProperty("onDemandToS3TestConfigurations")
  @Override
  public ImmutableList<OnDemandToS3TestConfiguration> onDemandToS3TestConfigurations() {
    return onDemandToS3TestConfigurations;
  }

  /**
   * @return The value of the {@code onDemandFromS3TestConfigurations} attribute
   */
  @JsonProperty("onDemandFromS3TestConfigurations")
  @Override
  public ImmutableList<OnDemandFromS3TestConfiguration> onDemandFromS3TestConfigurations() {
    return onDemandFromS3TestConfigurations;
  }

  /**
   * @return The value of the {@code listConnectorEntitiesTestConfigurations} attribute
   */
  @JsonProperty("listConnectorEntitiesTestConfigurations")
  @Override
  public ImmutableList<ListConnectorEntitiesTestConfiguration> listConnectorEntitiesTestConfigurations() {
    return listConnectorEntitiesTestConfigurations;
  }

  /**
   * @return The value of the {@code describeConnectorEntityTestConfigurations} attribute
   */
  @JsonProperty("describeConnectorEntityTestConfigurations")
  @Override
  public ImmutableList<DescribeConnectorEntityTestConfiguration> describeConnectorEntityTestConfigurations() {
    return describeConnectorEntityTestConfigurations;
  }

  /**
   * @return The value of the {@code testBucketConfiguration} attribute
   */
  @JsonProperty("testBucketConfiguration")
  @Override
  public TestBucketConfiguration testBucketConfiguration() {
    return testBucketConfiguration;
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link TestConfiguration#resourcePrefix() resourcePrefix} attribute.
   * @param value The value for resourcePrefix
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withResourcePrefix(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "resourcePrefix");
    if (Objects.equal(this.resourcePrefix, newValue)) return this;
    return new ImmutableTestConfiguration(
        newValue,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link TestConfiguration#resourcePrefix() resourcePrefix} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for resourcePrefix
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withResourcePrefix(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.resourcePrefix, value)) return this;
    return new ImmutableTestConfiguration(
        value,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#customConnectorConfigurations() customConnectorConfigurations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withCustomConnectorConfigurations(CustomConnectorConfiguration... elements) {
    ImmutableList<CustomConnectorConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        newValue,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#customConnectorConfigurations() customConnectorConfigurations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of customConnectorConfigurations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withCustomConnectorConfigurations(Iterable<? extends CustomConnectorConfiguration> elements) {
    if (this.customConnectorConfigurations == elements) return this;
    ImmutableList<CustomConnectorConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        newValue,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#customConnectorProfileConfigurations() customConnectorProfileConfigurations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withCustomConnectorProfileConfigurations(CustomConnectorProfileConfiguration... elements) {
    ImmutableList<CustomConnectorProfileConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        newValue,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#customConnectorProfileConfigurations() customConnectorProfileConfigurations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of customConnectorProfileConfigurations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withCustomConnectorProfileConfigurations(Iterable<? extends CustomConnectorProfileConfiguration> elements) {
    if (this.customConnectorProfileConfigurations == elements) return this;
    ImmutableList<CustomConnectorProfileConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        newValue,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#onDemandToS3TestConfigurations() onDemandToS3TestConfigurations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withOnDemandToS3TestConfigurations(OnDemandToS3TestConfiguration... elements) {
    ImmutableList<OnDemandToS3TestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        newValue,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#onDemandToS3TestConfigurations() onDemandToS3TestConfigurations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of onDemandToS3TestConfigurations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withOnDemandToS3TestConfigurations(Iterable<? extends OnDemandToS3TestConfiguration> elements) {
    if (this.onDemandToS3TestConfigurations == elements) return this;
    ImmutableList<OnDemandToS3TestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        newValue,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#onDemandFromS3TestConfigurations() onDemandFromS3TestConfigurations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withOnDemandFromS3TestConfigurations(OnDemandFromS3TestConfiguration... elements) {
    ImmutableList<OnDemandFromS3TestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        newValue,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#onDemandFromS3TestConfigurations() onDemandFromS3TestConfigurations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of onDemandFromS3TestConfigurations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withOnDemandFromS3TestConfigurations(Iterable<? extends OnDemandFromS3TestConfiguration> elements) {
    if (this.onDemandFromS3TestConfigurations == elements) return this;
    ImmutableList<OnDemandFromS3TestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        newValue,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#listConnectorEntitiesTestConfigurations() listConnectorEntitiesTestConfigurations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withListConnectorEntitiesTestConfigurations(ListConnectorEntitiesTestConfiguration... elements) {
    ImmutableList<ListConnectorEntitiesTestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        newValue,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#listConnectorEntitiesTestConfigurations() listConnectorEntitiesTestConfigurations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of listConnectorEntitiesTestConfigurations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withListConnectorEntitiesTestConfigurations(Iterable<? extends ListConnectorEntitiesTestConfiguration> elements) {
    if (this.listConnectorEntitiesTestConfigurations == elements) return this;
    ImmutableList<ListConnectorEntitiesTestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        newValue,
        this.describeConnectorEntityTestConfigurations,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#describeConnectorEntityTestConfigurations() describeConnectorEntityTestConfigurations}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withDescribeConnectorEntityTestConfigurations(DescribeConnectorEntityTestConfiguration... elements) {
    ImmutableList<DescribeConnectorEntityTestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        newValue,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link TestConfiguration#describeConnectorEntityTestConfigurations() describeConnectorEntityTestConfigurations}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of describeConnectorEntityTestConfigurations elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableTestConfiguration withDescribeConnectorEntityTestConfigurations(Iterable<? extends DescribeConnectorEntityTestConfiguration> elements) {
    if (this.describeConnectorEntityTestConfigurations == elements) return this;
    ImmutableList<DescribeConnectorEntityTestConfiguration> newValue = ImmutableList.copyOf(elements);
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        newValue,
        this.testBucketConfiguration);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link TestConfiguration#testBucketConfiguration() testBucketConfiguration} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param testBucketConfiguration A new value for testBucketConfiguration
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTestConfiguration withTestBucketConfiguration(TestBucketConfiguration testBucketConfiguration) {
    if (this.testBucketConfiguration == testBucketConfiguration) return this;
    TestBucketConfiguration newValue = Preconditions.checkNotNull(testBucketConfiguration, "testBucketConfiguration");
    return new ImmutableTestConfiguration(
        this.resourcePrefix,
        this.customConnectorConfigurations,
        this.customConnectorProfileConfigurations,
        this.onDemandToS3TestConfigurations,
        this.onDemandFromS3TestConfigurations,
        this.listConnectorEntitiesTestConfigurations,
        this.describeConnectorEntityTestConfigurations,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTestConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTestConfiguration
        && equalTo((ImmutableTestConfiguration) another);
  }

  private boolean equalTo(ImmutableTestConfiguration another) {
    return Objects.equal(resourcePrefix, another.resourcePrefix)
        && customConnectorConfigurations.equals(another.customConnectorConfigurations)
        && customConnectorProfileConfigurations.equals(another.customConnectorProfileConfigurations)
        && onDemandToS3TestConfigurations.equals(another.onDemandToS3TestConfigurations)
        && onDemandFromS3TestConfigurations.equals(another.onDemandFromS3TestConfigurations)
        && listConnectorEntitiesTestConfigurations.equals(another.listConnectorEntitiesTestConfigurations)
        && describeConnectorEntityTestConfigurations.equals(another.describeConnectorEntityTestConfigurations)
        && testBucketConfiguration.equals(another.testBucketConfiguration);
  }

  /**
   * Computes a hash code from attributes: {@code resourcePrefix}, {@code customConnectorConfigurations}, {@code customConnectorProfileConfigurations}, {@code onDemandToS3TestConfigurations}, {@code onDemandFromS3TestConfigurations}, {@code listConnectorEntitiesTestConfigurations}, {@code describeConnectorEntityTestConfigurations}, {@code testBucketConfiguration}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(resourcePrefix);
    h = h * 17 + customConnectorConfigurations.hashCode();
    h = h * 17 + customConnectorProfileConfigurations.hashCode();
    h = h * 17 + onDemandToS3TestConfigurations.hashCode();
    h = h * 17 + onDemandFromS3TestConfigurations.hashCode();
    h = h * 17 + listConnectorEntitiesTestConfigurations.hashCode();
    h = h * 17 + describeConnectorEntityTestConfigurations.hashCode();
    h = h * 17 + testBucketConfiguration.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code TestConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("TestConfiguration")
        .omitNullValues()
        .add("resourcePrefix", resourcePrefix)
        .add("customConnectorConfigurations", customConnectorConfigurations)
        .add("customConnectorProfileConfigurations", customConnectorProfileConfigurations)
        .add("onDemandToS3TestConfigurations", onDemandToS3TestConfigurations)
        .add("onDemandFromS3TestConfigurations", onDemandFromS3TestConfigurations)
        .add("listConnectorEntitiesTestConfigurations", listConnectorEntitiesTestConfigurations)
        .add("describeConnectorEntityTestConfigurations", describeConnectorEntityTestConfigurations)
        .add("testBucketConfiguration", testBucketConfiguration)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements TestConfiguration {
    Optional<String> resourcePrefix = Optional.empty();
    List<CustomConnectorConfiguration> customConnectorConfigurations = ImmutableList.of();
    List<CustomConnectorProfileConfiguration> customConnectorProfileConfigurations = ImmutableList.of();
    List<OnDemandToS3TestConfiguration> onDemandToS3TestConfigurations = ImmutableList.of();
    List<OnDemandFromS3TestConfiguration> onDemandFromS3TestConfigurations = ImmutableList.of();
    List<ListConnectorEntitiesTestConfiguration> listConnectorEntitiesTestConfigurations = ImmutableList.of();
    List<DescribeConnectorEntityTestConfiguration> describeConnectorEntityTestConfigurations = ImmutableList.of();
    @Nullable TestBucketConfiguration testBucketConfiguration;
    @JsonProperty("resourcePrefix")
    public void setResourcePrefix(Optional<String> resourcePrefix) {
      this.resourcePrefix = resourcePrefix;
    }
    @JsonProperty("customConnectorConfigurations")
    public void setCustomConnectorConfigurations(List<CustomConnectorConfiguration> customConnectorConfigurations) {
      this.customConnectorConfigurations = customConnectorConfigurations;
    }
    @JsonProperty("customConnectorProfileConfigurations")
    public void setCustomConnectorProfileConfigurations(List<CustomConnectorProfileConfiguration> customConnectorProfileConfigurations) {
      this.customConnectorProfileConfigurations = customConnectorProfileConfigurations;
    }
    @JsonProperty("onDemandToS3TestConfigurations")
    public void setOnDemandToS3TestConfigurations(List<OnDemandToS3TestConfiguration> onDemandToS3TestConfigurations) {
      this.onDemandToS3TestConfigurations = onDemandToS3TestConfigurations;
    }
    @JsonProperty("onDemandFromS3TestConfigurations")
    public void setOnDemandFromS3TestConfigurations(List<OnDemandFromS3TestConfiguration> onDemandFromS3TestConfigurations) {
      this.onDemandFromS3TestConfigurations = onDemandFromS3TestConfigurations;
    }
    @JsonProperty("listConnectorEntitiesTestConfigurations")
    public void setListConnectorEntitiesTestConfigurations(List<ListConnectorEntitiesTestConfiguration> listConnectorEntitiesTestConfigurations) {
      this.listConnectorEntitiesTestConfigurations = listConnectorEntitiesTestConfigurations;
    }
    @JsonProperty("describeConnectorEntityTestConfigurations")
    public void setDescribeConnectorEntityTestConfigurations(List<DescribeConnectorEntityTestConfiguration> describeConnectorEntityTestConfigurations) {
      this.describeConnectorEntityTestConfigurations = describeConnectorEntityTestConfigurations;
    }
    @JsonProperty("testBucketConfiguration")
    public void setTestBucketConfiguration(TestBucketConfiguration testBucketConfiguration) {
      this.testBucketConfiguration = testBucketConfiguration;
    }
    @Override
    public Optional<String> resourcePrefix() { throw new UnsupportedOperationException(); }
    @Override
    public List<CustomConnectorConfiguration> customConnectorConfigurations() { throw new UnsupportedOperationException(); }
    @Override
    public List<CustomConnectorProfileConfiguration> customConnectorProfileConfigurations() { throw new UnsupportedOperationException(); }
    @Override
    public List<OnDemandToS3TestConfiguration> onDemandToS3TestConfigurations() { throw new UnsupportedOperationException(); }
    @Override
    public List<OnDemandFromS3TestConfiguration> onDemandFromS3TestConfigurations() { throw new UnsupportedOperationException(); }
    @Override
    public List<ListConnectorEntitiesTestConfiguration> listConnectorEntitiesTestConfigurations() { throw new UnsupportedOperationException(); }
    @Override
    public List<DescribeConnectorEntityTestConfiguration> describeConnectorEntityTestConfigurations() { throw new UnsupportedOperationException(); }
    @Override
    public TestBucketConfiguration testBucketConfiguration() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableTestConfiguration fromJson(Json json) {
    ImmutableTestConfiguration.Builder builder = ImmutableTestConfiguration.builder();
    if (json.resourcePrefix != null) {
      builder.resourcePrefix(json.resourcePrefix);
    }
    if (json.customConnectorConfigurations != null) {
      builder.addAllCustomConnectorConfigurations(json.customConnectorConfigurations);
    }
    if (json.customConnectorProfileConfigurations != null) {
      builder.addAllCustomConnectorProfileConfigurations(json.customConnectorProfileConfigurations);
    }
    if (json.onDemandToS3TestConfigurations != null) {
      builder.addAllOnDemandToS3TestConfigurations(json.onDemandToS3TestConfigurations);
    }
    if (json.onDemandFromS3TestConfigurations != null) {
      builder.addAllOnDemandFromS3TestConfigurations(json.onDemandFromS3TestConfigurations);
    }
    if (json.listConnectorEntitiesTestConfigurations != null) {
      builder.addAllListConnectorEntitiesTestConfigurations(json.listConnectorEntitiesTestConfigurations);
    }
    if (json.describeConnectorEntityTestConfigurations != null) {
      builder.addAllDescribeConnectorEntityTestConfigurations(json.describeConnectorEntityTestConfigurations);
    }
    if (json.testBucketConfiguration != null) {
      builder.testBucketConfiguration(json.testBucketConfiguration);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link TestConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable TestConfiguration instance
   */
  public static ImmutableTestConfiguration copyOf(TestConfiguration instance) {
    if (instance instanceof ImmutableTestConfiguration) {
      return (ImmutableTestConfiguration) instance;
    }
    return ImmutableTestConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTestConfiguration ImmutableTestConfiguration}.
   * @return A new ImmutableTestConfiguration builder
   */
  public static ImmutableTestConfiguration.Builder builder() {
    return new ImmutableTestConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTestConfiguration ImmutableTestConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TEST_BUCKET_CONFIGURATION = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String resourcePrefix;
    private ImmutableList.Builder<CustomConnectorConfiguration> customConnectorConfigurations = ImmutableList.builder();
    private ImmutableList.Builder<CustomConnectorProfileConfiguration> customConnectorProfileConfigurations = ImmutableList.builder();
    private ImmutableList.Builder<OnDemandToS3TestConfiguration> onDemandToS3TestConfigurations = ImmutableList.builder();
    private ImmutableList.Builder<OnDemandFromS3TestConfiguration> onDemandFromS3TestConfigurations = ImmutableList.builder();
    private ImmutableList.Builder<ListConnectorEntitiesTestConfiguration> listConnectorEntitiesTestConfigurations = ImmutableList.builder();
    private ImmutableList.Builder<DescribeConnectorEntityTestConfiguration> describeConnectorEntityTestConfigurations = ImmutableList.builder();
    private @Nullable TestBucketConfiguration testBucketConfiguration;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code TestConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(TestConfiguration instance) {
      Preconditions.checkNotNull(instance, "instance");
      Optional<String> resourcePrefixOptional = instance.resourcePrefix();
      if (resourcePrefixOptional.isPresent()) {
        resourcePrefix(resourcePrefixOptional);
      }
      addAllCustomConnectorConfigurations(instance.customConnectorConfigurations());
      addAllCustomConnectorProfileConfigurations(instance.customConnectorProfileConfigurations());
      addAllOnDemandToS3TestConfigurations(instance.onDemandToS3TestConfigurations());
      addAllOnDemandFromS3TestConfigurations(instance.onDemandFromS3TestConfigurations());
      addAllListConnectorEntitiesTestConfigurations(instance.listConnectorEntitiesTestConfigurations());
      addAllDescribeConnectorEntityTestConfigurations(instance.describeConnectorEntityTestConfigurations());
      testBucketConfiguration(instance.testBucketConfiguration());
      return this;
    }

    /**
     * Initializes the optional value {@link TestConfiguration#resourcePrefix() resourcePrefix} to resourcePrefix.
     * @param resourcePrefix The value for resourcePrefix
     * @return {@code this} builder for chained invocation
     */
    public final Builder resourcePrefix(String resourcePrefix) {
      this.resourcePrefix = Preconditions.checkNotNull(resourcePrefix, "resourcePrefix");
      return this;
    }

    /**
     * Initializes the optional value {@link TestConfiguration#resourcePrefix() resourcePrefix} to resourcePrefix.
     * @param resourcePrefix The value for resourcePrefix
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder resourcePrefix(Optional<String> resourcePrefix) {
      this.resourcePrefix = resourcePrefix.orElse(null);
      return this;
    }

    /**
     * Adds one element to {@link TestConfiguration#customConnectorConfigurations() customConnectorConfigurations} list.
     * @param element A customConnectorConfigurations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCustomConnectorConfigurations(CustomConnectorConfiguration element) {
      this.customConnectorConfigurations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link TestConfiguration#customConnectorConfigurations() customConnectorConfigurations} list.
     * @param elements An array of customConnectorConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCustomConnectorConfigurations(CustomConnectorConfiguration... elements) {
      this.customConnectorConfigurations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link TestConfiguration#customConnectorConfigurations() customConnectorConfigurations} list.
     * @param elements An iterable of customConnectorConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder customConnectorConfigurations(Iterable<? extends CustomConnectorConfiguration> elements) {
      this.customConnectorConfigurations = ImmutableList.builder();
      return addAllCustomConnectorConfigurations(elements);
    }

    /**
     * Adds elements to {@link TestConfiguration#customConnectorConfigurations() customConnectorConfigurations} list.
     * @param elements An iterable of customConnectorConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllCustomConnectorConfigurations(Iterable<? extends CustomConnectorConfiguration> elements) {
      this.customConnectorConfigurations.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link TestConfiguration#customConnectorProfileConfigurations() customConnectorProfileConfigurations} list.
     * @param element A customConnectorProfileConfigurations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCustomConnectorProfileConfigurations(CustomConnectorProfileConfiguration element) {
      this.customConnectorProfileConfigurations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link TestConfiguration#customConnectorProfileConfigurations() customConnectorProfileConfigurations} list.
     * @param elements An array of customConnectorProfileConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addCustomConnectorProfileConfigurations(CustomConnectorProfileConfiguration... elements) {
      this.customConnectorProfileConfigurations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link TestConfiguration#customConnectorProfileConfigurations() customConnectorProfileConfigurations} list.
     * @param elements An iterable of customConnectorProfileConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder customConnectorProfileConfigurations(Iterable<? extends CustomConnectorProfileConfiguration> elements) {
      this.customConnectorProfileConfigurations = ImmutableList.builder();
      return addAllCustomConnectorProfileConfigurations(elements);
    }

    /**
     * Adds elements to {@link TestConfiguration#customConnectorProfileConfigurations() customConnectorProfileConfigurations} list.
     * @param elements An iterable of customConnectorProfileConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllCustomConnectorProfileConfigurations(Iterable<? extends CustomConnectorProfileConfiguration> elements) {
      this.customConnectorProfileConfigurations.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link TestConfiguration#onDemandToS3TestConfigurations() onDemandToS3TestConfigurations} list.
     * @param element A onDemandToS3TestConfigurations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOnDemandToS3TestConfigurations(OnDemandToS3TestConfiguration element) {
      this.onDemandToS3TestConfigurations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link TestConfiguration#onDemandToS3TestConfigurations() onDemandToS3TestConfigurations} list.
     * @param elements An array of onDemandToS3TestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOnDemandToS3TestConfigurations(OnDemandToS3TestConfiguration... elements) {
      this.onDemandToS3TestConfigurations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link TestConfiguration#onDemandToS3TestConfigurations() onDemandToS3TestConfigurations} list.
     * @param elements An iterable of onDemandToS3TestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder onDemandToS3TestConfigurations(Iterable<? extends OnDemandToS3TestConfiguration> elements) {
      this.onDemandToS3TestConfigurations = ImmutableList.builder();
      return addAllOnDemandToS3TestConfigurations(elements);
    }

    /**
     * Adds elements to {@link TestConfiguration#onDemandToS3TestConfigurations() onDemandToS3TestConfigurations} list.
     * @param elements An iterable of onDemandToS3TestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllOnDemandToS3TestConfigurations(Iterable<? extends OnDemandToS3TestConfiguration> elements) {
      this.onDemandToS3TestConfigurations.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link TestConfiguration#onDemandFromS3TestConfigurations() onDemandFromS3TestConfigurations} list.
     * @param element A onDemandFromS3TestConfigurations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOnDemandFromS3TestConfigurations(OnDemandFromS3TestConfiguration element) {
      this.onDemandFromS3TestConfigurations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link TestConfiguration#onDemandFromS3TestConfigurations() onDemandFromS3TestConfigurations} list.
     * @param elements An array of onDemandFromS3TestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addOnDemandFromS3TestConfigurations(OnDemandFromS3TestConfiguration... elements) {
      this.onDemandFromS3TestConfigurations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link TestConfiguration#onDemandFromS3TestConfigurations() onDemandFromS3TestConfigurations} list.
     * @param elements An iterable of onDemandFromS3TestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder onDemandFromS3TestConfigurations(Iterable<? extends OnDemandFromS3TestConfiguration> elements) {
      this.onDemandFromS3TestConfigurations = ImmutableList.builder();
      return addAllOnDemandFromS3TestConfigurations(elements);
    }

    /**
     * Adds elements to {@link TestConfiguration#onDemandFromS3TestConfigurations() onDemandFromS3TestConfigurations} list.
     * @param elements An iterable of onDemandFromS3TestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllOnDemandFromS3TestConfigurations(Iterable<? extends OnDemandFromS3TestConfiguration> elements) {
      this.onDemandFromS3TestConfigurations.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link TestConfiguration#listConnectorEntitiesTestConfigurations() listConnectorEntitiesTestConfigurations} list.
     * @param element A listConnectorEntitiesTestConfigurations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addListConnectorEntitiesTestConfigurations(ListConnectorEntitiesTestConfiguration element) {
      this.listConnectorEntitiesTestConfigurations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link TestConfiguration#listConnectorEntitiesTestConfigurations() listConnectorEntitiesTestConfigurations} list.
     * @param elements An array of listConnectorEntitiesTestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addListConnectorEntitiesTestConfigurations(ListConnectorEntitiesTestConfiguration... elements) {
      this.listConnectorEntitiesTestConfigurations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link TestConfiguration#listConnectorEntitiesTestConfigurations() listConnectorEntitiesTestConfigurations} list.
     * @param elements An iterable of listConnectorEntitiesTestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder listConnectorEntitiesTestConfigurations(Iterable<? extends ListConnectorEntitiesTestConfiguration> elements) {
      this.listConnectorEntitiesTestConfigurations = ImmutableList.builder();
      return addAllListConnectorEntitiesTestConfigurations(elements);
    }

    /**
     * Adds elements to {@link TestConfiguration#listConnectorEntitiesTestConfigurations() listConnectorEntitiesTestConfigurations} list.
     * @param elements An iterable of listConnectorEntitiesTestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllListConnectorEntitiesTestConfigurations(Iterable<? extends ListConnectorEntitiesTestConfiguration> elements) {
      this.listConnectorEntitiesTestConfigurations.addAll(elements);
      return this;
    }

    /**
     * Adds one element to {@link TestConfiguration#describeConnectorEntityTestConfigurations() describeConnectorEntityTestConfigurations} list.
     * @param element A describeConnectorEntityTestConfigurations element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addDescribeConnectorEntityTestConfigurations(DescribeConnectorEntityTestConfiguration element) {
      this.describeConnectorEntityTestConfigurations.add(element);
      return this;
    }

    /**
     * Adds elements to {@link TestConfiguration#describeConnectorEntityTestConfigurations() describeConnectorEntityTestConfigurations} list.
     * @param elements An array of describeConnectorEntityTestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addDescribeConnectorEntityTestConfigurations(DescribeConnectorEntityTestConfiguration... elements) {
      this.describeConnectorEntityTestConfigurations.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link TestConfiguration#describeConnectorEntityTestConfigurations() describeConnectorEntityTestConfigurations} list.
     * @param elements An iterable of describeConnectorEntityTestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder describeConnectorEntityTestConfigurations(Iterable<? extends DescribeConnectorEntityTestConfiguration> elements) {
      this.describeConnectorEntityTestConfigurations = ImmutableList.builder();
      return addAllDescribeConnectorEntityTestConfigurations(elements);
    }

    /**
     * Adds elements to {@link TestConfiguration#describeConnectorEntityTestConfigurations() describeConnectorEntityTestConfigurations} list.
     * @param elements An iterable of describeConnectorEntityTestConfigurations elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllDescribeConnectorEntityTestConfigurations(Iterable<? extends DescribeConnectorEntityTestConfiguration> elements) {
      this.describeConnectorEntityTestConfigurations.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link TestConfiguration#testBucketConfiguration() testBucketConfiguration} attribute.
     * @param testBucketConfiguration The value for testBucketConfiguration 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder testBucketConfiguration(TestBucketConfiguration testBucketConfiguration) {
      this.testBucketConfiguration = Preconditions.checkNotNull(testBucketConfiguration, "testBucketConfiguration");
      initBits &= ~INIT_BIT_TEST_BUCKET_CONFIGURATION;
      return this;
    }

    /**
     * Builds a new {@link ImmutableTestConfiguration ImmutableTestConfiguration}.
     * @return An immutable instance of TestConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTestConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableTestConfiguration(
          resourcePrefix,
          customConnectorConfigurations.build(),
          customConnectorProfileConfigurations.build(),
          onDemandToS3TestConfigurations.build(),
          onDemandFromS3TestConfigurations.build(),
          listConnectorEntitiesTestConfigurations.build(),
          describeConnectorEntityTestConfigurations.build(),
          testBucketConfiguration);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_TEST_BUCKET_CONFIGURATION) != 0) attributes.add("testBucketConfiguration");
      return "Cannot build TestConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
