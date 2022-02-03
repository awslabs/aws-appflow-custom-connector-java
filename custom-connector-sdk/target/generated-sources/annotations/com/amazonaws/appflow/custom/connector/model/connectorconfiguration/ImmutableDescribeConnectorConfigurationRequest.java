package com.amazonaws.appflow.custom.connector.model.connectorconfiguration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link DescribeConnectorConfigurationRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDescribeConnectorConfigurationRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("DescribeConnectorConfigurationRequest")
public final class ImmutableDescribeConnectorConfigurationRequest
    implements DescribeConnectorConfigurationRequest {
  private final String locale;
  private final @Nullable String connectorLabel;

  private ImmutableDescribeConnectorConfigurationRequest(ImmutableDescribeConnectorConfigurationRequest.Builder builder) {
    this.connectorLabel = builder.connectorLabel;
    this.locale = builder.locale != null
        ? builder.locale
        : Objects.requireNonNull(DescribeConnectorConfigurationRequest.super.locale(), "locale");
  }

  private ImmutableDescribeConnectorConfigurationRequest(String locale, @Nullable String connectorLabel) {
    this.locale = locale;
    this.connectorLabel = connectorLabel;
  }

  /**
   * Locale value to get the localized string values for labels and descriptions for connector settings. Default is
   * en-US.
   */
  @JsonProperty("locale")
  @Override
  public String locale() {
    return locale;
  }

  /**
   * Connector label to be used for logging.
   * @return
   */
  @JsonProperty("connectorLabel")
  @Override
  public @Nullable String connectorLabel() {
    return connectorLabel;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationRequest#locale() locale} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param locale A new value for locale
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationRequest withLocale(String locale) {
    if (this.locale.equals(locale)) return this;
    String newValue = Objects.requireNonNull(locale, "locale");
    return new ImmutableDescribeConnectorConfigurationRequest(newValue, this.connectorLabel);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeConnectorConfigurationRequest#connectorLabel() connectorLabel} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param connectorLabel A new value for connectorLabel (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeConnectorConfigurationRequest withConnectorLabel(@Nullable String connectorLabel) {
    if (Objects.equals(this.connectorLabel, connectorLabel)) return this;
    return new ImmutableDescribeConnectorConfigurationRequest(this.locale, connectorLabel);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDescribeConnectorConfigurationRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDescribeConnectorConfigurationRequest
        && equalTo((ImmutableDescribeConnectorConfigurationRequest) another);
  }

  private boolean equalTo(ImmutableDescribeConnectorConfigurationRequest another) {
    return locale.equals(another.locale)
        && Objects.equals(connectorLabel, another.connectorLabel);
  }

  /**
   * Computes a hash code from attributes: {@code locale}, {@code connectorLabel}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + locale.hashCode();
    h = h * 17 + Objects.hashCode(connectorLabel);
    return h;
  }

  /**
   * Prints the immutable value {@code DescribeConnectorConfigurationRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "DescribeConnectorConfigurationRequest{"
        + "locale=" + locale
        + ", connectorLabel=" + connectorLabel
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonTypeInfo(use=JsonTypeInfo.Id.NONE)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements DescribeConnectorConfigurationRequest {
    @Nullable String locale;
    @Nullable String connectorLabel;
    @JsonProperty("locale")
    public void setLocale(String locale) {
      this.locale = locale;
    }
    @JsonProperty("connectorLabel")
    public void setConnectorLabel(@Nullable String connectorLabel) {
      this.connectorLabel = connectorLabel;
    }
    @Override
    public String locale() { throw new UnsupportedOperationException(); }
    @Override
    public String connectorLabel() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableDescribeConnectorConfigurationRequest fromJson(Json json) {
    ImmutableDescribeConnectorConfigurationRequest.Builder builder = ImmutableDescribeConnectorConfigurationRequest.builder();
    if (json.locale != null) {
      builder.locale(json.locale);
    }
    if (json.connectorLabel != null) {
      builder.connectorLabel(json.connectorLabel);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link DescribeConnectorConfigurationRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DescribeConnectorConfigurationRequest instance
   */
  public static ImmutableDescribeConnectorConfigurationRequest copyOf(DescribeConnectorConfigurationRequest instance) {
    if (instance instanceof ImmutableDescribeConnectorConfigurationRequest) {
      return (ImmutableDescribeConnectorConfigurationRequest) instance;
    }
    return ImmutableDescribeConnectorConfigurationRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDescribeConnectorConfigurationRequest ImmutableDescribeConnectorConfigurationRequest}.
   * @return A new ImmutableDescribeConnectorConfigurationRequest builder
   */
  public static ImmutableDescribeConnectorConfigurationRequest.Builder builder() {
    return new ImmutableDescribeConnectorConfigurationRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDescribeConnectorConfigurationRequest ImmutableDescribeConnectorConfigurationRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private @Nullable String locale;
    private @Nullable String connectorLabel;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code DescribeConnectorConfigurationRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DescribeConnectorConfigurationRequest instance) {
      Objects.requireNonNull(instance, "instance");
      locale(instance.locale());
      @Nullable String connectorLabelValue = instance.connectorLabel();
      if (connectorLabelValue != null) {
        connectorLabel(connectorLabelValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationRequest#locale() locale} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link DescribeConnectorConfigurationRequest#locale() locale}.</em>
     * @param locale The value for locale 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder locale(String locale) {
      this.locale = Objects.requireNonNull(locale, "locale");
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeConnectorConfigurationRequest#connectorLabel() connectorLabel} attribute.
     * @param connectorLabel The value for connectorLabel (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorLabel(@Nullable String connectorLabel) {
      this.connectorLabel = connectorLabel;
      return this;
    }

    /**
     * Builds a new {@link ImmutableDescribeConnectorConfigurationRequest ImmutableDescribeConnectorConfigurationRequest}.
     * @return An immutable instance of DescribeConnectorConfigurationRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDescribeConnectorConfigurationRequest build() {
      return new ImmutableDescribeConnectorConfigurationRequest(this);
    }
  }
}
