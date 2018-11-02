import React, { Component } from "react";
import "./font-awesome.css";
import "react-bootstrap/dist/css/bootstrap.css";
import "react-fontawesome/dist/js/bootstrap.js";
class Login extends Component {
  state = {};
  render() {
    return (
      <div class="container">
        <div class="omb_login">
          <h3 class="omb_authTitle">
            Login or <a href="#">Sign up</a>
          </h3>
          <div class="row omb_row-sm-offset-3 omb_socialButtons">
            <div class="col-xs-4 col-sm-2">
              <a href="#" class="btn btn-lg btn-block omb_btn-facebook">
                <i class="fa fa-facebook visible-xs" />
                <span class="hidden-xs">Facebook</span>
              </a>
            </div>
            <div class="col-xs-4 col-sm-2">
              <a href="#" class="btn btn-lg btn-block omb_btn-twitter">
                <i class="fa fa-twitter visible-xs" />
                <span class="hidden-xs">Twitter</span>
              </a>
            </div>
            <div class="col-xs-4 col-sm-2">
              <a href="#" class="btn btn-lg btn-block omb_btn-google">
                <i class="fa fa-google-plus visible-xs" />
                <span class="hidden-xs">Google+</span>
              </a>
            </div>
          </div>

          <div class="row omb_row-sm-offset-3 omb_loginOr">
            <div class="col-xs-12 col-sm-6">
              <hr class="omb_hrOr" />
              <span class="omb_spanOr">or</span>
            </div>
          </div>
          <div class="row omb_row-sm-offset-3">
            <div class="col-xs-12 col-sm-6">
              <form
                class="omb_loginForm"
                action=""
                autocomplete="off"
                method="POST"
              >
                <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa fa-user" />
                  </span>
                  <input
                    type="text"
                    class="form-control"
                    name="username"
                    placeholder="email address"
                  />
                </div>
                <span class="help-block" />

                <div class="input-group">
                  <span class="input-group-addon">
                    <i class="fa fa-lock" />
                  </span>
                  <input
                    type="password"
                    class="form-control"
                    name="password"
                    placeholder="Password"
                  />
                </div>
                <span class="help-block">Password error</span>

                <button class="btn btn-lg btn-primary btn-block" type="submit">
                  Login
                </button>
              </form>
            </div>
          </div>
          <div class="row omb_row-sm-offset-3">
            <div class="col-xs-12 col-sm-3">
              <label class="checkbox">
                <input type="checkbox" value="remember-me">
                  Remember Me
                </input>
              </label>
            </div>
            <div class="col-xs-12 col-sm-3">
              <p class="omb_forgotPwd">
                <a href="#">Forgot password?</a>
              </p>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
