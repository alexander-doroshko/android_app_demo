load("@rules_cc//cc/toolchains:cc_toolchain.bzl", "cc_toolchain")
load(":toolchain_config.bzl", "android_stub_cc_toolchain_config")

package(default_visibility = ["//visibility:public"])

filegroup(name = "empty")

android_stub_cc_toolchain_config(name = "config")

cc_toolchain(
    name = "stub",
    all_files = ":empty",
    compiler_files = ":empty",
    dwp_files = ":empty",
    linker_files = ":empty",
    objcopy_files = ":empty",
    strip_files = ":empty",
    supports_param_files = 0,
    toolchain_config = ":config",
    toolchain_identifier = "android-stub",
)

toolchain(
    name = "arm64-v8a",
    target_compatible_with = [
        "@platforms//os:android",
        "@platforms//cpu:arm64",
    ],
    toolchain = ":stub",
    toolchain_type = "@rules_cc//cc:toolchain_type",
)

toolchain(
    name = "x86_64",
    target_compatible_with = [
        "@platforms//os:android",
        "@platforms//cpu:x86_64",
    ],
    toolchain = ":stub",
    toolchain_type = "@rules_cc//cc:toolchain_type",
)
