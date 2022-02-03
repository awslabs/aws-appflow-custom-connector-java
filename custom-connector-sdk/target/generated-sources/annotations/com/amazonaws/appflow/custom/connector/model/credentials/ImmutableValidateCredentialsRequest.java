package com.amazonaws.appflow.custom.connector.model.credentials;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ValidateCredentialsRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableValidateCredentialsRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("ValidateCredentialsRequest")
public final class ImmutableValidateCredentialsRequest
    implements ValidateCredentialsRequest {
  private final @Nullable Map<String, String> connectorRuntimeSettings;
  private final Credentials credentials;

  private ImmutableValidateCredentialsRequest(
      @Nullable Map<String, String> connectorRuntimeSettings,
      Credentials credentials) {
    this.connectorRuntimeSettings = connectorRuntimeSettings;
    this.credentials = credentials;
  }

  /**
   * Connector Settings provided for validating the connector credentials. All the Connector Settings for
   * CONNECTOR_PROFILE scope will be provided as input.
   */
  @JsonProperty("connectorRuntimeSettings")
  @Override
  public @Nullable Map<String, String> connectorRuntimeSettings() {
    return connectorRuntimeSettings;
  }

  /**
   * Credentials needs to validate.
   */
  @JsonProperty("credentials")
  @Override
  public Credentials credentials() {
    return credentials;
  }

  /**
   * Copy the current immutable object by replacing the {@link ValidateCredentialsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorRuntimeSettings The entries to be added to the connectorRuntimeSettings map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableValidateCredentialsRequest withConnectorRuntimeSettings(@Nullable Map<String, ? extends String> connectorRuntimeSettings) {
    if (this.connectorRuntimeSettings == connectorRuntimeSettings) return this;
    @Nullable Map<String, String> newValue = connectorRuntimeSettings == null ? null : createUnmodifiableMap(true, false, connectorRuntimeSettings);
    return new ImmutableValidateCredentialsRequest(newValue, this.credentials);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ValidateCredentialsRequest#credentials() credentials} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param credentials A new value for credentials
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableValidateCredentialsRequest withCredentials(Credentials credentials) {
    if (this.credentials == credentials) return this;
    Credentials newValue = Objects.requireNonNull(credentials, "credentials");
    return new ImmutableValidateCredentialsRequest(this.connectorRuntimeSettings, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableValidateCredentialsRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableValidateCredentialsRequest
        && equalTo((ImmutableValidateCredentialsRequest) another);
  }

  private boolean equalTo(ImmutableValidateCredentialsRequest another) {
    return Objects.equals(connectorRuntimeSettings, another.connectorRuntimeSettings)
        && credentials.equals(another.credentials);
  }

  /**
   * Computes a hash code from attributes: {@code connectorRuntimeSettings}, {@code credentials}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(connectorRuntimeSettings);
    h = h * 17 + credentials.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ValidateCredentialsRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ValidateCredentialsRequest{"
        + "connectorRuntimeSettings=" + connectorRuntimeSettings
        + ", credentials=" + credentials
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
      implements ValidateCredentialsRequest {
    @Nullable Map<String, String> connectorRuntimeSettings;
    @Nullable Credentials credentials;
    @JsonProperty("connectorRuntimeSettings")
    public void setConnectorRuntimeSettings(@Nullable Map<String, String> connectorRuntimeSettings) {
      this.connectorRuntimeSettings = connectorRuntimeSettings;
    }
    @JsonProperty("credentials")
    public void setCredentials(Credentials credentials) {
      this.credentials = credentials;
    }
    @Override
    public Map<String, String> connectorRuntimeSettings() { throw new UnsupportedOperationException(); }
    @Override
    public Credentials credentials() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableValidateCredentialsRequest fromJson(Json json) {
    ImmutableValidateCredentialsRequest.Builder builder = ImmutableValidateCredentialsRequest.builder();
    if (json.connectorRuntimeSettings != null) {
      builder.putAllConnectorRuntimeSettings(json.connectorRuntimeSettings);
    }
    if (json.credentials != null) {
      builder.credentials(json.credentials);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ValidateCredentialsRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ValidateCredentialsRequest instance
   */
  public static ImmutableValidateCredentialsRequest copyOf(ValidateCredentialsRequest instance) {
    if (instance instanceof ImmutableValidateCredentialsRequest) {
      return (ImmutableValidateCredentialsRequest) instance;
    }
    return ImmutableValidateCredentialsRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableValidateCredentialsRequest ImmutableValidateCredentialsRequest}.
   * @return A new ImmutableValidateCredentialsRequest builder
   */
  public static ImmutableValidateCredentialsRequest.Builder builder() {
    return new ImmutableValidateCredentialsRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableValidateCredentialsRequest ImmutableValidateCredentialsRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CREDENTIALS = 0x1L;
    private long initBits = 0x1L;

    private Map<String, String> connectorRuntimeSettings = null;
    private @Nullable Credentials credentials;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ValidateCredentialsRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ValidateCredentialsRequest instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable Map<String, String> connectorRuntimeSettingsValue = instance.connectorRuntimeSettings();
      if (connectorRuntimeSettingsValue != null) {
        putAllConnectorRuntimeSettings(connectorRuntimeSettingsValue);
      }
      credentials(instance.credentials());
      return this;
    }

    /**
     * Put one entry to the {@link ValidateCredentialsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map.
     * @param key The key in the connectorRuntimeSettings map
     * @param value The associated value in the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putConnectorRuntimeSettings(String key, String value) {
      if (this.connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = new LinkedHashMap<String, String>();
      }
      this.connectorRuntimeSettings.put(
          Objects.requireNonNull(key, "connectorRuntimeSettings key"),
          Objects.requireNonNull(value, "connectorRuntimeSettings value"));
      return this;
    }

    /**
     * Put one entry to the {@link ValidateCredentialsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putConnectorRuntimeSettings(Map.Entry<String, ? extends String> entry) {
      if (this.connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = new LinkedHashMap<String, String>();
      }
      String k = entry.getKey();
      String v = entry.getValue();
      this.connectorRuntimeSettings.put(
          Objects.requireNonNull(k, "connectorRuntimeSettings key"),
          Objects.requireNonNull(v, "connectorRuntimeSettings value"));
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link ValidateCredentialsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted as keys or values, but parameter itself can be null
     * @param connectorRuntimeSettings The entries that will be added to the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorRuntimeSettings(@Nullable Map<String, ? extends String> connectorRuntimeSettings) {
      if (connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = null;
        return this;
      }
      this.connectorRuntimeSettings = new LinkedHashMap<String, String>();
      return putAllConnectorRuntimeSettings(connectorRuntimeSettings);
    }

    /**
     * Put all mappings from the specified map as entries to {@link ValidateCredentialsRequest#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted
     * @param connectorRuntimeSettings The entries that will be added to the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllConnectorRuntimeSettings(Map<String, ? extends String> connectorRuntimeSettings) {
      if (this.connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = new LinkedHashMap<String, String>();
      }
      for (Map.Entry<String, ? extends String> entry : connectorRuntimeSettings.entrySet()) {
        String k = entry.getKey();
        String v = entry.getValue();
        this.connectorRuntimeSettings.put(
            Objects.requireNonNull(k, "connectorRuntimeSettings key"),
            Objects.requireNonNull(v, "connectorRuntimeSettings value"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link ValidateCredentialsRequest#credentials() credentials} attribute.
     * @param credentials The value for credentials 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder credentials(Credentials credentials) {
      this.credentials = Objects.requireNonNull(credentials, "credentials");
      initBits &= ~INIT_BIT_CREDENTIALS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableValidateCredentialsRequest ImmutableValidateCredentialsRequest}.
     * @return An immutable instance of ValidateCredentialsRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableValidateCredentialsRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableValidateCredentialsRequest(
          connectorRuntimeSettings == null ? null : createUnmodifiableMap(false, false, connectorRuntimeSettings),
          credentials);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_CREDENTIALS) != 0) attributes.add("credentials");
      return "Cannot build ValidateCredentialsRequest, some of required attributes are not set " + attributes;
    }
  }

  private static <K, V> Map<K, V> createUnmodifiableMap(boolean checkNulls, boolean skipNulls, Map<? extends K, ? extends V> map) {
    switch (map.size()) {
    case 0: return Collections.emptyMap();
    case 1: {
      Map.Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
      K k = e.getKey();
      V v = e.getValue();
      if (checkNulls) {
        Objects.requireNonNull(k, "key");
        Objects.requireNonNull(v, "value");
      }
      if (skipNulls && (k == null || v == null)) {
        return Collections.emptyMap();
      }
      return Collections.singletonMap(k, v);
    }
    default: {
      Map<K, V> linkedMap = new LinkedHashMap<K, V>(map.size());
      if (skipNulls || checkNulls) {
        for (Map.Entry<? extends K, ? extends V> e : map.entrySet()) {
          K k = e.getKey();
          V v = e.getValue();
          if (skipNulls) {
            if (k == null || v == null) continue;
          } else if (checkNulls) {
            Objects.requireNonNull(k, "key");
            Objects.requireNonNull(v, "value");
          }
          linkedMap.put(k, v);
        }
      } else {
        linkedMap.putAll(map);
      }
      return Collections.unmodifiableMap(linkedMap);
    }
    }
  }
}
