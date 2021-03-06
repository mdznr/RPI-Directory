import webapp2
from google.appengine.api import users
from google.appengine.ext.webapp.util import run_wsgi_app
import os
from google.appengine.ext.webapp import template
import logging
from models import Person


class DetailPage(webapp2.RequestHandler):
  def get(self, rcs_id):
    logging.error('RCSID: ' + rcs_id)
    user = users.get_current_user()
    template_values = {"active": "dashboard",
                       "rcs_id": rcs_id,
                       "person": Person.get_by_id(rcs_id),
                       "user": user}
    path = os.path.join(os.path.dirname(__file__), 'html/detail.html')
    self.response.out.write(template.render(path, template_values))

app = webapp2.WSGIApplication([('/detail/([^/]+)', DetailPage)])