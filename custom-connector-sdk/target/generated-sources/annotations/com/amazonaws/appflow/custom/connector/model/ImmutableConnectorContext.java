package com.amazonaws.appflow.custom.connector.model;

import com.amazonaws.appflow.custom.connector.model.credentials.Credentials;
import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link ConnectorContext}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableConnectorContext.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableConnectorContext
    implements ConnectorContext {
  private final @Nullable ImmutableMap<String, String> connectorRuntimeSettings;
  private final @Nullable Credentials credentials;
  private final String apiVersion;
  private final @Nullable String flowName;
  private final @Nullable String executionId;
  private final @Nullable String connectorProfileLabel;
  private final @Nullable EntityDefinition entityDefinition;

  private ImmutableConnectorContext(
      @Nullable ImmutableMap<String, String> connectorRuntimeSettings,
      @Nullable Credentials credentials,
      String apiVersion,
      @Nullable String flowName,
      @Nullable String executionId,
      @Nullable String connectorProfileLabel,
      @Nullable EntityDefinition entityDefinition) {
    this.connectorRuntimeSettings = connectorRuntimeSettings;
    this.credentials = credentials;
    this.apiVersion = apiVersion;
    this.flowName = flowName;
    this.executionId = executionId;
    this.connectorProfileLabel = connectorProfileLabel;
    this.entityDefinition = entityDefinition;
  }

  /**
   * Connector settings required for API call. For example, for the Read API it will contains all the
   * ConnectorSettingScope.SOURCE settings. Key will be ConnectorSetting.key() and value will be the input provided by
   * user.
   */
  @JsonProperty("connectorRuntimeSettings")
  @Override
  public @Nullable ImmutableMap<String, String> connectorRuntimeSettings() {
    return connectorRuntimeSettings;
  }

  /**
   * Credentials which will be used to make API call.
   */
  @JsonProperty("credentials")
  @Override
  public @Nullable Credentials credentials() {
    return credentials;
  }

  /**
   * API version to use. Value will be the API Version supported by Connector as part of Connector Configuration.
   */
  @JsonProperty("apiVersion")
  @Override
  public String apiVersion() {
    return apiVersion;
  }

  /**
   * Flow name to use for logging.
   * @return
   */
  @JsonProperty("flowName")
  @Override
  public @Nullable String flowName() {
    return flowName;
  }

  /**
   * Execution Id to use for logging.
   * @return
   */
  @JsonProperty("executionId")
  @Override
  public @Nullable String executionId() {
    return executionId;
  }

  /**
   * Connector profile name to use for logging.
   * @return
   */
  @JsonProperty("connectorProfileLabel")
  @Override
  public @Nullable String connectorProfileLabel() {
    return connectorProfileLabel;
  }

  /**
   * Entity definition in compressed form. As it will be required by calling application as well as connector lambda
   * to serialize/deserialize request/response payload.
   */
  @JsonProperty("entityDefinition")
  @Override
  public @Nullable EntityDefinition entityDefinition() {
    return entityDefinition;
  }

  /**
   * Copy the current immutable object by replacing the {@link ConnectorContext#connectorRuntimeSettings() connectorRuntimeSettings} map with the specified map.
   * Nulls are not permitted as keys or values.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorRuntimeSettings The entries to be added to the connectorRuntimeSettings map
   * @return A modified copy of {@code this} object
   */
  public final ImmutableConnectorContext withConnectorRuntimeSettings(@Nullable Map<String, ? extends String> connectorRuntimeSettings) {
    if (this.connectorRuntimeSettings == connectorRuntimeSettings) return this;
    @Nullable ImmutableMap<String, String> newValue = connectorRuntimeSettings == null ? null : ImmutableMap.copyOf(connectorRuntimeSettings);
    return new ImmutableConnectorContext(
        newValue,
        this.credentials,
        this.apiVersion,
        this.flowName,
        this.executionId,
        this.connectorProfileLabel,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorContext#credentials() credentials} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param credentials A new value for credentials (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorContext withCredentials(@Nullable Credentials credentials) {
    if (this.credentials == credentials) return this;
    return new ImmutableConnectorContext(
        this.connectorRuntimeSettings,
        credentials,
        this.apiVersion,
        this.flowName,
        this.executionId,
        this.connectorProfileLabel,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorContext#apiVersion() apiVersion} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param apiVersion A new value for apiVersion
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorContext withApiVersion(String apiVersion) {
    if (this.apiVersion.equals(apiVersion)) return this;
    String newValue = Preconditions.checkNotNull(apiVersion, "apiVersion");
    return new ImmutableConnectorContext(
        this.connectorRuntimeSettings,
        this.credentials,
        newValue,
        this.flowName,
        this.executionId,
        this.connectorProfileLabel,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorContext#flowName() flowName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param flowName A new value for flowName (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorContext withFlowName(@Nullable String flowName) {
    if (Objects.equal(this.flowName, flowName)) return this;
    return new ImmutableConnectorContext(
        this.connectorRuntimeSettings,
        this.credentials,
        this.apiVersion,
        flowName,
        this.executionId,
        this.connectorProfileLabel,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorContext#executionId() executionId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param executionId A new value for executionId (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorContext withExecutionId(@Nullable String executionId) {
    if (Objects.equal(this.executionId, executionId)) return this;
    return new ImmutableConnectorContext(
        this.connectorRuntimeSettings,
        this.credentials,
        this.apiVersion,
        this.flowName,
        executionId,
        this.connectorProfileLabel,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorContext#connectorProfileLabel() connectorProfileLabel} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param connectorProfileLabel A new value for connectorProfileLabel (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorContext withConnectorProfileLabel(@Nullable String connectorProfileLabel) {
    if (Objects.equal(this.connectorProfileLabel, connectorProfileLabel)) return this;
    return new ImmutableConnectorContext(
        this.connectorRuntimeSettings,
        this.credentials,
        this.apiVersion,
        this.flowName,
        this.executionId,
        connectorProfileLabel,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ConnectorContext#entityDefinition() entityDefinition} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entityDefinition A new value for entityDefinition (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableConnectorContext withEntityDefinition(@Nullable EntityDefinition entityDefinition) {
    if (this.entityDefinition == entityDefinition) return this;
    return new ImmutableConnectorContext(
        this.connectorRuntimeSettings,
        this.credentials,
        this.apiVersion,
        this.flowName,
        this.executionId,
        this.connectorProfileLabel,
        entityDefinition);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableConnectorContext} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableConnectorContext
        && equalTo((ImmutableConnectorContext) another);
  }

  private boolean equalTo(ImmutableConnectorContext another) {
    return Objects.equal(connectorRuntimeSettings, another.connectorRuntimeSettings)
        && Objects.equal(credentials, another.credentials)
        && apiVersion.equals(another.apiVersion)
        && Objects.equal(flowName, another.flowName)
        && Objects.equal(executionId, another.executionId)
        && Objects.equal(connectorProfileLabel, another.connectorProfileLabel)
        && Objects.equal(entityDefinition, another.entityDefinition);
  }

  /**
   * Computes a hash code from attributes: {@code connectorRuntimeSettings}, {@code credentials}, {@code apiVersion}, {@code flowName}, {@code executionId}, {@code connectorProfileLabel}, {@code entityDefinition}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(connectorRuntimeSettings);
    h = h * 17 + Objects.hashCode(credentials);
    h = h * 17 + apiVersion.hashCode();
    h = h * 17 + Objects.hashCode(flowName);
    h = h * 17 + Objects.hashCode(executionId);
    h = h * 17 + Objects.hashCode(connectorProfileLabel);
    h = h * 17 + Objects.hashCode(entityDefinition);
    return h;
  }

  /**
   * Prints the immutable value {@code ConnectorContext} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("ConnectorContext")
        .omitNullValues()
        .add("connectorRuntimeSettings", connectorRuntimeSettings)
        .add("credentials", credentials)
        .add("apiVersion", apiVersion)
        .add("flowName", flowName)
        .add("executionId", executionId)
        .add("connectorProfileLabel", connectorProfileLabel)
        .add("entityDefinition", entityDefinition)
        .toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements ConnectorContext {
    @Nullable Map<String, String> connectorRuntimeSettings;
    @Nullable Credentials credentials;
    @Nullable String apiVersion;
    @Nullable String flowName;
    @Nullable String executionId;
    @Nullable String connectorProfileLabel;
    @Nullable EntityDefinition entityDefinition;
    @JsonProperty("connectorRuntimeSettings")
    public void setConnectorRuntimeSettings(@Nullable Map<String, String> connectorRuntimeSettings) {
      this.connectorRuntimeSettings = connectorRuntimeSettings;
    }
    @JsonProperty("credentials")
    public void setCredentials(@Nullable Credentials credentials) {
      this.credentials = credentials;
    }
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
      this.apiVersion = apiVersion;
    }
    @JsonProperty("flowName")
    public void setFlowName(@Nullable String flowName) {
      this.flowName = flowName;
    }
    @JsonProperty("executionId")
    public void setExecutionId(@Nullable String executionId) {
      this.executionId = executionId;
    }
    @JsonProperty("connectorProfileLabel")
    public void setConnectorProfileLabel(@Nullable String connectorProfileLabel) {
      this.connectorProfileLabel = connectorProfileLabel;
    }
    @JsonProperty("entityDefinition")
    public void setEntityDefinition(@Nullable EntityDefinition entityDefinition) {
      this.entityDefinition = entityDefinition;
    }
    @Override
    public Map<String, String> connectorRuntimeSettings() { throw new UnsupportedOperationException(); }
    @Override
    public Credentials credentials() { throw new UnsupportedOperationException(); }
    @Override
    public String apiVersion() { throw new UnsupportedOperationException(); }
    @Override
    public String flowName() { throw new UnsupportedOperationException(); }
    @Override
    public String executionId() { throw new UnsupportedOperationException(); }
    @Override
    public String connectorProfileLabel() { throw new UnsupportedOperationException(); }
    @Override
    public EntityDefinition entityDefinition() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableConnectorContext fromJson(Json json) {
    ImmutableConnectorContext.Builder builder = ImmutableConnectorContext.builder();
    if (json.connectorRuntimeSettings != null) {
      builder.putAllConnectorRuntimeSettings(json.connectorRuntimeSettings);
    }
    if (json.credentials != null) {
      builder.credentials(json.credentials);
    }
    if (json.apiVersion != null) {
      builder.apiVersion(json.apiVersion);
    }
    if (json.flowName != null) {
      builder.flowName(json.flowName);
    }
    if (json.executionId != null) {
      builder.executionId(json.executionId);
    }
    if (json.connectorProfileLabel != null) {
      builder.connectorProfileLabel(json.connectorProfileLabel);
    }
    if (json.entityDefinition != null) {
      builder.entityDefinition(json.entityDefinition);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ConnectorContext} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ConnectorContext instance
   */
  public static ImmutableConnectorContext copyOf(ConnectorContext instance) {
    if (instance instanceof ImmutableConnectorContext) {
      return (ImmutableConnectorContext) instance;
    }
    return ImmutableConnectorContext.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableConnectorContext ImmutableConnectorContext}.
   * @return A new ImmutableConnectorContext builder
   */
  public static ImmutableConnectorContext.Builder builder() {
    return new ImmutableConnectorContext.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableConnectorContext ImmutableConnectorContext}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_API_VERSION = 0x1L;
    private long initBits = 0x1L;

    private ImmutableMap.Builder<String, String> connectorRuntimeSettings = null;
    private @Nullable Credentials credentials;
    private @Nullable String apiVersion;
    private @Nullable String flowName;
    private @Nullable String executionId;
    private @Nullable String connectorProfileLabel;
    private @Nullable EntityDefinition entityDefinition;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ConnectorContext} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ConnectorContext instance) {
      Preconditions.checkNotNull(instance, "instance");
      @Nullable Map<String, String> connectorRuntimeSettingsValue = instance.connectorRuntimeSettings();
      if (connectorRuntimeSettingsValue != null) {
        putAllConnectorRuntimeSettings(connectorRuntimeSettingsValue);
      }
      @Nullable Credentials credentialsValue = instance.credentials();
      if (credentialsValue != null) {
        credentials(credentialsValue);
      }
      apiVersion(instance.apiVersion());
      @Nullable String flowNameValue = instance.flowName();
      if (flowNameValue != null) {
        flowName(flowNameValue);
      }
      @Nullable String executionIdValue = instance.executionId();
      if (executionIdValue != null) {
        executionId(executionIdValue);
      }
      @Nullable String connectorProfileLabelValue = instance.connectorProfileLabel();
      if (connectorProfileLabelValue != null) {
        connectorProfileLabel(connectorProfileLabelValue);
      }
      @Nullable EntityDefinition entityDefinitionValue = instance.entityDefinition();
      if (entityDefinitionValue != null) {
        entityDefinition(entityDefinitionValue);
      }
      return this;
    }

    /**
     * Put one entry to the {@link ConnectorContext#connectorRuntimeSettings() connectorRuntimeSettings} map.
     * @param key The key in the connectorRuntimeSettings map
     * @param value The associated value in the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putConnectorRuntimeSettings(String key, String value) {
      if (this.connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = ImmutableMap.builder();
      }
      this.connectorRuntimeSettings.put(key, value);
      return this;
    }

    /**
     * Put one entry to the {@link ConnectorContext#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putConnectorRuntimeSettings(Map.Entry<String, ? extends String> entry) {
      if (this.connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = ImmutableMap.builder();
      }
      this.connectorRuntimeSettings.put(entry);
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link ConnectorContext#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted as keys or values, but parameter itself can be null
     * @param connectorRuntimeSettings The entries that will be added to the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorRuntimeSettings(@Nullable Map<String, ? extends String> connectorRuntimeSettings) {
      if (connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = null;
        return this;
      }
      this.connectorRuntimeSettings = ImmutableMap.builder();
      return putAllConnectorRuntimeSettings(connectorRuntimeSettings);
    }

    /**
     * Put all mappings from the specified map as entries to {@link ConnectorContext#connectorRuntimeSettings() connectorRuntimeSettings} map. Nulls are not permitted
     * @param connectorRuntimeSettings The entries that will be added to the connectorRuntimeSettings map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllConnectorRuntimeSettings(Map<String, ? extends String> connectorRuntimeSettings) {
      if (this.connectorRuntimeSettings == null) {
        this.connectorRuntimeSettings = ImmutableMap.builder();
      }
      this.connectorRuntimeSettings.putAll(connectorRuntimeSettings);
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorContext#credentials() credentials} attribute.
     * @param credentials The value for credentials (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder credentials(@Nullable Credentials credentials) {
      this.credentials = credentials;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorContext#apiVersion() apiVersion} attribute.
     * @param apiVersion The value for apiVersion 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder apiVersion(String apiVersion) {
      this.apiVersion = Preconditions.checkNotNull(apiVersion, "apiVersion");
      initBits &= ~INIT_BIT_API_VERSION;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorContext#flowName() flowName} attribute.
     * @param flowName The value for flowName (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder flowName(@Nullable String flowName) {
      this.flowName = flowName;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorContext#executionId() executionId} attribute.
     * @param executionId The value for executionId (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder executionId(@Nullable String executionId) {
      this.executionId = executionId;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorContext#connectorProfileLabel() connectorProfileLabel} attribute.
     * @param connectorProfileLabel The value for connectorProfileLabel (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorProfileLabel(@Nullable String connectorProfileLabel) {
      this.connectorProfileLabel = connectorProfileLabel;
      return this;
    }

    /**
     * Initializes the value for the {@link ConnectorContext#entityDefinition() entityDefinition} attribute.
     * @param entityDefinition The value for entityDefinition (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityDefinition(@Nullable EntityDefinition entityDefinition) {
      this.entityDefinition = entityDefinition;
      return this;
    }

    /**
     * Builds a new {@link ImmutableConnectorContext ImmutableConnectorContext}.
     * @return An immutable instance of ConnectorContext
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableConnectorContext build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableConnectorContext(
          connectorRuntimeSettings == null ? null : connectorRuntimeSettings.build(),
          credentials,
          apiVersion,
          flowName,
          executionId,
          connectorProfileLabel,
          entityDefinition);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_API_VERSION) != 0) attributes.add("apiVersion");
      return "Cannot build ConnectorContext, some of required attributes are not set " + attributes;
    }
  }
}
