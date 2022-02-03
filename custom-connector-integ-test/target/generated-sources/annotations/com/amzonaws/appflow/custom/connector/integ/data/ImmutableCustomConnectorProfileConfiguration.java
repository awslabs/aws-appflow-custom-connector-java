package com.amzonaws.appflow.custom.connector.integ.data;

import com.amazonaws.services.appflow.model.OAuth2Properties;
import com.amzonaws.appflow.custom.connector.integ.providers.AuthenticationType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link CustomConnectorProfileConfiguration}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCustomConnectorProfileConfiguration.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableCustomConnectorProfileConfiguration
    implements CustomConnectorProfileConfiguration {
  private final @Nullable String secretsManagerArn;
  private final String name;
  private final @Nullable OAuth2Properties oAuth2Properties;
  private final @Nullable String connectorName;
  private final @Nullable Map<String, String> profileProperties;
  private final AuthenticationType authenticationType;
  private final @Nullable String defaultApiVersion;

  private ImmutableCustomConnectorProfileConfiguration(
      @Nullable String secretsManagerArn,
      String name,
      @Nullable OAuth2Properties oAuth2Properties,
      @Nullable String connectorName,
      @Nullable Map<String, String> profileProperties,
      AuthenticationType authenticationType,
      @Nullable String defaultApiVersion) {
    this.secretsManagerArn = secretsManagerArn;
    this.name = name;
    this.oAuth2Properties = oAuth2Properties;
    this.connectorName = connectorName;
    this.profileProperties = profileProperties;
    this.authenticationType = authenticationType;
    this.defaultApiVersion = defaultApiVersion;
  }

  /**
   * @return The value of the {@code secretsManagerArn} attribute
   */
  @JsonProperty("secretsManagerArn")
  @Override
  public Optional<String> secretsManagerArn() {
    return Optional.ofNullable(secretsManagerArn);
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * @return The value of the {@code oAuth2Properties} attribute
   */
  @JsonProperty("oAuth2Properties")
  @Override
  public Optional<OAuth2Properties> oAuth2Properties() {
    return Optional.ofNullable(oAuth2Properties);
  }

  /**
   * @return The value of the {@code connectorName} attribute
   */
  @JsonProperty("connectorName")
  @Override
  public Optional<String> connectorName() {
    return Optional.ofNullable(connectorName);
  }

  /**
   * @return The value of the {@code profileProperties} attribute
   */
  @JsonProperty("profileProperties")
  @Override
  public Optional<Map<String, String>> profileProperties() {
    return Optional.ofNullable(profileProperties);
  }

  /**
   * @return The value of the {@code authenticationType} attribute
   */
  @JsonProperty("authenticationType")
  @Override
  public AuthenticationType authenticationType() {
    return authenticationType;
  }

  /**
   * @return The value of the {@code defaultApiVersion} attribute
   */
  @JsonProperty("defaultApiVersion")
  @Override
  public Optional<String> defaultApiVersion() {
    return Optional.ofNullable(defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CustomConnectorProfileConfiguration#secretsManagerArn() secretsManagerArn} attribute.
   * @param value The value for secretsManagerArn
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withSecretsManagerArn(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "secretsManagerArn");
    if (Objects.equal(this.secretsManagerArn, newValue)) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        newValue,
        this.name,
        this.oAuth2Properties,
        this.connectorName,
        this.profileProperties,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CustomConnectorProfileConfiguration#secretsManagerArn() secretsManagerArn} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for secretsManagerArn
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withSecretsManagerArn(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.secretsManagerArn, value)) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        value,
        this.name,
        this.oAuth2Properties,
        this.connectorName,
        this.profileProperties,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CustomConnectorProfileConfiguration#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param name A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withName(String name) {
    if (this.name.equals(name)) return this;
    String newValue = Preconditions.checkNotNull(name, "name");
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        newValue,
        this.oAuth2Properties,
        this.connectorName,
        this.profileProperties,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CustomConnectorProfileConfiguration#oAuth2Properties() oAuth2Properties} attribute.
   * @param value The value for oAuth2Properties
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withOAuth2Properties(OAuth2Properties value) {
    @Nullable OAuth2Properties newValue = Preconditions.checkNotNull(value, "oAuth2Properties");
    if (this.oAuth2Properties == newValue) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        newValue,
        this.connectorName,
        this.profileProperties,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CustomConnectorProfileConfiguration#oAuth2Properties() oAuth2Properties} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for oAuth2Properties
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withOAuth2Properties(Optional<OAuth2Properties> optional) {
    @Nullable OAuth2Properties value = optional.orElse(null);
    if (this.oAuth2Properties == value) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        value,
        this.connectorName,
        this.profileProperties,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CustomConnectorProfileConfiguration#connectorName() connectorName} attribute.
   * @param value The value for connectorName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withConnectorName(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "connectorName");
    if (Objects.equal(this.connectorName, newValue)) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        this.oAuth2Properties,
        newValue,
        this.profileProperties,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CustomConnectorProfileConfiguration#connectorName() connectorName} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for connectorName
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withConnectorName(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.connectorName, value)) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        this.oAuth2Properties,
        value,
        this.profileProperties,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CustomConnectorProfileConfiguration#profileProperties() profileProperties} attribute.
   * @param value The value for profileProperties
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withProfileProperties(Map<String, String> value) {
    @Nullable Map<String, String> newValue = Preconditions.checkNotNull(value, "profileProperties");
    if (this.profileProperties == newValue) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        this.oAuth2Properties,
        this.connectorName,
        newValue,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CustomConnectorProfileConfiguration#profileProperties() profileProperties} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for profileProperties
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withProfileProperties(Optional<Map<String, String>> optional) {
    @Nullable Map<String, String> value = optional.orElse(null);
    if (this.profileProperties == value) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        this.oAuth2Properties,
        this.connectorName,
        value,
        this.authenticationType,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CustomConnectorProfileConfiguration#authenticationType() authenticationType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param authenticationType A new value for authenticationType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withAuthenticationType(AuthenticationType authenticationType) {
    if (this.authenticationType == authenticationType) return this;
    AuthenticationType newValue = Preconditions.checkNotNull(authenticationType, "authenticationType");
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        this.oAuth2Properties,
        this.connectorName,
        this.profileProperties,
        newValue,
        this.defaultApiVersion);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link CustomConnectorProfileConfiguration#defaultApiVersion() defaultApiVersion} attribute.
   * @param value The value for defaultApiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withDefaultApiVersion(String value) {
    @Nullable String newValue = Preconditions.checkNotNull(value, "defaultApiVersion");
    if (Objects.equal(this.defaultApiVersion, newValue)) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        this.oAuth2Properties,
        this.connectorName,
        this.profileProperties,
        this.authenticationType,
        newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link CustomConnectorProfileConfiguration#defaultApiVersion() defaultApiVersion} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for defaultApiVersion
   * @return A modified copy of {@code this} object
   */
  public final ImmutableCustomConnectorProfileConfiguration withDefaultApiVersion(Optional<String> optional) {
    @Nullable String value = optional.orElse(null);
    if (Objects.equal(this.defaultApiVersion, value)) return this;
    return new ImmutableCustomConnectorProfileConfiguration(
        this.secretsManagerArn,
        this.name,
        this.oAuth2Properties,
        this.connectorName,
        this.profileProperties,
        this.authenticationType,
        value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCustomConnectorProfileConfiguration} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCustomConnectorProfileConfiguration
        && equalTo((ImmutableCustomConnectorProfileConfiguration) another);
  }

  private boolean equalTo(ImmutableCustomConnectorProfileConfiguration another) {
    return Objects.equal(secretsManagerArn, another.secretsManagerArn)
        && name.equals(another.name)
        && Objects.equal(oAuth2Properties, another.oAuth2Properties)
        && Objects.equal(connectorName, another.connectorName)
        && Objects.equal(profileProperties, another.profileProperties)
        && authenticationType.equals(another.authenticationType)
        && Objects.equal(defaultApiVersion, another.defaultApiVersion);
  }

  /**
   * Computes a hash code from attributes: {@code secretsManagerArn}, {@code name}, {@code oAuth2Properties}, {@code connectorName}, {@code profileProperties}, {@code authenticationType}, {@code defaultApiVersion}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(secretsManagerArn);
    h = h * 17 + name.hashCode();
    h = h * 17 + Objects.hashCode(oAuth2Properties);
    h = h * 17 + Objects.hashCode(connectorName);
    h = h * 17 + Objects.hashCode(profileProperties);
    h = h * 17 + authenticationType.hashCode();
    h = h * 17 + Objects.hashCode(defaultApiVersion);
    return h;
  }

  /**
   * Prints the immutable value {@code CustomConnectorProfileConfiguration} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("CustomConnectorProfileConfiguration")
        .omitNullValues()
        .add("secretsManagerArn", secretsManagerArn)
        .add("name", name)
        .add("oAuth2Properties", oAuth2Properties)
        .add("connectorName", connectorName)
        .add("profileProperties", profileProperties)
        .add("authenticationType", authenticationType)
        .add("defaultApiVersion", defaultApiVersion)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements CustomConnectorProfileConfiguration {
    Optional<String> secretsManagerArn = Optional.empty();
    @Nullable String name;
    Optional<OAuth2Properties> oAuth2Properties = Optional.empty();
    Optional<String> connectorName = Optional.empty();
    Optional<Map<String, String>> profileProperties = Optional.empty();
    @Nullable AuthenticationType authenticationType;
    Optional<String> defaultApiVersion = Optional.empty();
    @JsonProperty("secretsManagerArn")
    public void setSecretsManagerArn(Optional<String> secretsManagerArn) {
      this.secretsManagerArn = secretsManagerArn;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("oAuth2Properties")
    public void setOAuth2Properties(Optional<OAuth2Properties> oAuth2Properties) {
      this.oAuth2Properties = oAuth2Properties;
    }
    @JsonProperty("connectorName")
    public void setConnectorName(Optional<String> connectorName) {
      this.connectorName = connectorName;
    }
    @JsonProperty("profileProperties")
    public void setProfileProperties(Optional<Map<String, String>> profileProperties) {
      this.profileProperties = profileProperties;
    }
    @JsonProperty("authenticationType")
    public void setAuthenticationType(AuthenticationType authenticationType) {
      this.authenticationType = authenticationType;
    }
    @JsonProperty("defaultApiVersion")
    public void setDefaultApiVersion(Optional<String> defaultApiVersion) {
      this.defaultApiVersion = defaultApiVersion;
    }
    @Override
    public Optional<String> secretsManagerArn() { throw new UnsupportedOperationException(); }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<OAuth2Properties> oAuth2Properties() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> connectorName() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Map<String, String>> profileProperties() { throw new UnsupportedOperationException(); }
    @Override
    public AuthenticationType authenticationType() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> defaultApiVersion() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableCustomConnectorProfileConfiguration fromJson(Json json) {
    ImmutableCustomConnectorProfileConfiguration.Builder builder = ImmutableCustomConnectorProfileConfiguration.builder();
    if (json.secretsManagerArn != null) {
      builder.secretsManagerArn(json.secretsManagerArn);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.oAuth2Properties != null) {
      builder.oAuth2Properties(json.oAuth2Properties);
    }
    if (json.connectorName != null) {
      builder.connectorName(json.connectorName);
    }
    if (json.profileProperties != null) {
      builder.profileProperties(json.profileProperties);
    }
    if (json.authenticationType != null) {
      builder.authenticationType(json.authenticationType);
    }
    if (json.defaultApiVersion != null) {
      builder.defaultApiVersion(json.defaultApiVersion);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link CustomConnectorProfileConfiguration} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CustomConnectorProfileConfiguration instance
   */
  public static ImmutableCustomConnectorProfileConfiguration copyOf(CustomConnectorProfileConfiguration instance) {
    if (instance instanceof ImmutableCustomConnectorProfileConfiguration) {
      return (ImmutableCustomConnectorProfileConfiguration) instance;
    }
    return ImmutableCustomConnectorProfileConfiguration.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCustomConnectorProfileConfiguration ImmutableCustomConnectorProfileConfiguration}.
   * @return A new ImmutableCustomConnectorProfileConfiguration builder
   */
  public static ImmutableCustomConnectorProfileConfiguration.Builder builder() {
    return new ImmutableCustomConnectorProfileConfiguration.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCustomConnectorProfileConfiguration ImmutableCustomConnectorProfileConfiguration}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_AUTHENTICATION_TYPE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String secretsManagerArn;
    private @Nullable String name;
    private @Nullable OAuth2Properties oAuth2Properties;
    private @Nullable String connectorName;
    private @Nullable Map<String, String> profileProperties;
    private @Nullable AuthenticationType authenticationType;
    private @Nullable String defaultApiVersion;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CustomConnectorProfileConfiguration} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CustomConnectorProfileConfiguration instance) {
      Preconditions.checkNotNull(instance, "instance");
      Optional<String> secretsManagerArnOptional = instance.secretsManagerArn();
      if (secretsManagerArnOptional.isPresent()) {
        secretsManagerArn(secretsManagerArnOptional);
      }
      name(instance.name());
      Optional<OAuth2Properties> oAuth2PropertiesOptional = instance.oAuth2Properties();
      if (oAuth2PropertiesOptional.isPresent()) {
        oAuth2Properties(oAuth2PropertiesOptional);
      }
      Optional<String> connectorNameOptional = instance.connectorName();
      if (connectorNameOptional.isPresent()) {
        connectorName(connectorNameOptional);
      }
      Optional<Map<String, String>> profilePropertiesOptional = instance.profileProperties();
      if (profilePropertiesOptional.isPresent()) {
        profileProperties(profilePropertiesOptional);
      }
      authenticationType(instance.authenticationType());
      Optional<String> defaultApiVersionOptional = instance.defaultApiVersion();
      if (defaultApiVersionOptional.isPresent()) {
        defaultApiVersion(defaultApiVersionOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#secretsManagerArn() secretsManagerArn} to secretsManagerArn.
     * @param secretsManagerArn The value for secretsManagerArn
     * @return {@code this} builder for chained invocation
     */
    public final Builder secretsManagerArn(String secretsManagerArn) {
      this.secretsManagerArn = Preconditions.checkNotNull(secretsManagerArn, "secretsManagerArn");
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#secretsManagerArn() secretsManagerArn} to secretsManagerArn.
     * @param secretsManagerArn The value for secretsManagerArn
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder secretsManagerArn(Optional<String> secretsManagerArn) {
      this.secretsManagerArn = secretsManagerArn.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link CustomConnectorProfileConfiguration#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Preconditions.checkNotNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#oAuth2Properties() oAuth2Properties} to oAuth2Properties.
     * @param oAuth2Properties The value for oAuth2Properties
     * @return {@code this} builder for chained invocation
     */
    public final Builder oAuth2Properties(OAuth2Properties oAuth2Properties) {
      this.oAuth2Properties = Preconditions.checkNotNull(oAuth2Properties, "oAuth2Properties");
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#oAuth2Properties() oAuth2Properties} to oAuth2Properties.
     * @param oAuth2Properties The value for oAuth2Properties
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder oAuth2Properties(Optional<OAuth2Properties> oAuth2Properties) {
      this.oAuth2Properties = oAuth2Properties.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#connectorName() connectorName} to connectorName.
     * @param connectorName The value for connectorName
     * @return {@code this} builder for chained invocation
     */
    public final Builder connectorName(String connectorName) {
      this.connectorName = Preconditions.checkNotNull(connectorName, "connectorName");
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#connectorName() connectorName} to connectorName.
     * @param connectorName The value for connectorName
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorName(Optional<String> connectorName) {
      this.connectorName = connectorName.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#profileProperties() profileProperties} to profileProperties.
     * @param profileProperties The value for profileProperties
     * @return {@code this} builder for chained invocation
     */
    public final Builder profileProperties(Map<String, String> profileProperties) {
      this.profileProperties = Preconditions.checkNotNull(profileProperties, "profileProperties");
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#profileProperties() profileProperties} to profileProperties.
     * @param profileProperties The value for profileProperties
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder profileProperties(Optional<Map<String, String>> profileProperties) {
      this.profileProperties = profileProperties.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link CustomConnectorProfileConfiguration#authenticationType() authenticationType} attribute.
     * @param authenticationType The value for authenticationType 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder authenticationType(AuthenticationType authenticationType) {
      this.authenticationType = Preconditions.checkNotNull(authenticationType, "authenticationType");
      initBits &= ~INIT_BIT_AUTHENTICATION_TYPE;
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#defaultApiVersion() defaultApiVersion} to defaultApiVersion.
     * @param defaultApiVersion The value for defaultApiVersion
     * @return {@code this} builder for chained invocation
     */
    public final Builder defaultApiVersion(String defaultApiVersion) {
      this.defaultApiVersion = Preconditions.checkNotNull(defaultApiVersion, "defaultApiVersion");
      return this;
    }

    /**
     * Initializes the optional value {@link CustomConnectorProfileConfiguration#defaultApiVersion() defaultApiVersion} to defaultApiVersion.
     * @param defaultApiVersion The value for defaultApiVersion
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder defaultApiVersion(Optional<String> defaultApiVersion) {
      this.defaultApiVersion = defaultApiVersion.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableCustomConnectorProfileConfiguration ImmutableCustomConnectorProfileConfiguration}.
     * @return An immutable instance of CustomConnectorProfileConfiguration
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCustomConnectorProfileConfiguration build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCustomConnectorProfileConfiguration(
          secretsManagerArn,
          name,
          oAuth2Properties,
          connectorName,
          profileProperties,
          authenticationType,
          defaultApiVersion);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_AUTHENTICATION_TYPE) != 0) attributes.add("authenticationType");
      return "Cannot build CustomConnectorProfileConfiguration, some of required attributes are not set " + attributes;
    }
  }
}
